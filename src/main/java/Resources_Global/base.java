package Resources_Global;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class base {
	
	//public static ChromeDriver driver;
	public static WebDriver driver;
	//public static RemoteWebDriver driver;
	String CurrPath = System.getProperty("user.dir");
	Properties prop;
	ExtentReports extent;
	static URL remoteUrl;
	static DesiredCapabilities cap;
	
	public String getProperty(String PropertyKey) throws IOException
	{
		FileReader reader=new FileReader(CurrPath + "//src//main/java//Resources_Global//GlobalData.properties");
		prop = new Properties();
		prop.load(reader);
		return prop.getProperty(PropertyKey);
	}
	
	public WebDriver InitializeDriver(String BrowserName) throws IOException
	{
		//String BrowserName = getProperty("Browser");
		if(BrowserName.contains("chrome") || BrowserName.equals("Chrome") || BrowserName.equals("chrome") || BrowserName.equals("Google Chrome") || BrowserName.equals("goole chrome"))
		{
			//cap = DesiredCapabilities.chrome();
			//remoteUrl = new URL("http://localhost:4444/wd/hub");
			System.setProperty("webdriver.chrome.driver", CurrPath + "//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			
			//ChromeDriver chromedriver = new ChromeDriver();
			//driver = new RemoteWebDriver(remoteUrl, cap);
		}
		
		else if(BrowserName.contains("firefox") || BrowserName.equalsIgnoreCase("Firefox") || BrowserName.equalsIgnoreCase("Mozilla"))
		{
			cap = DesiredCapabilities.firefox();
			remoteUrl = new URL("http://localhost:4444/wd/hub");
			driver = new RemoteWebDriver(remoteUrl, cap);
			//System.setProperty("webdriver.chrome.driver", CurrPath + "//Drivers//chromedriver.exe");
			//driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		return driver;
	}
	
	@SuppressWarnings("unused")
	public WebDriverWait SetExplicitWait(long WaitTime)
	{
		WebDriverWait ExplicitWait;
		return ExplicitWait = new WebDriverWait(driver,WaitTime);
	}
	
	public ExtentReports ExtentReport() throws IOException
	{
		ExtentSparkReporter Spark = new ExtentSparkReporter(CurrPath +"//ExtentReports//ExtentReport.html");
		Spark.loadXMLConfig(CurrPath + "//Resources//extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(Spark);
		return extent;
		
	}
	
	public void takeSnapShot(String filename) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot = (TakesScreenshot) driver;
        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(CurrPath + "//" + filename + ".png");

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

    }
}
