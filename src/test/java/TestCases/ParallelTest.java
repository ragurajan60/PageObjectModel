package TestCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ParallelTest {
	ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	//public WebDriver driver;
	public static WebDriver driver;
	static URL remoteUrl;
	static DesiredCapabilities cap;
	String CurrPath = System.getProperty("user.dir");
	
	@BeforeTest
	public void Initialize()
	{
		System.setProperty("webdriver.chrome.driver", CurrPath + "//Drivers//chromedriver.exe");
		driver = tldriver.get();
		driver = new ChromeDriver();
		//cap = DesiredCapabilities.chrome();
		//remoteUrl = new URL("http://localhost:4444/wd/hub");
		//driver = new RemoteWebDriver(remoteUrl, cap);
	}
	
	@Test
	@Parameters("browser")
	public void test1() throws MalformedURLException
	{
		driver.navigate().to("https://leqlb040.upoint.qc.alight.com/web/bmc/login");
		System.out.println("Test1 is method is running " +Thread.currentThread().getId() + " Browsername: ");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(true, false);
		softAssert.assertAll();
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
}
