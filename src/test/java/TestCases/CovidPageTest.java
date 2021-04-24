package TestCases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ObjectRepository.Covid19OrgPage;
import Resources_Global.base;

public class CovidPageTest extends base {

	private static Logger Log = LogManager.getLogger(ParticipantLogin.class.getName());
	ExtentReports extent;
	ExtentSparkReporter Spark;
	ExtentTest logger;
	String CurrPath = System.getProperty("user.dir");
	Covid19OrgPage cop;

	@BeforeTest
	public void Initialize() throws IOException {
		ExtentSparkReporter Spark = new ExtentSparkReporter(CurrPath + "//ExtentReports//ExtentReport.html");
		Spark.loadXMLConfig(CurrPath + "//Resources//extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(Spark);
		extent.setSystemInfo("Developer", "Ragurajan N");
		driver = InitializeDriver("chrome");
		cop = new Covid19OrgPage(driver);
		Log.debug("Chrome Browser is Launched Successfully");
		driver.manage().window().maximize();
		Log.info("Chrome Browser Maximized Successfully");

	}

	@Test
	public void ChromeParticipantLoginTest() throws Exception {
		driver.get(getProperty("CovidTracker"));
		takeSnapShot("test",driver);
		System.out.println(driver.getTitle());
		Log.error("Successfully Navigated to URL: " + getProperty("CovidTracker"));
		SetExplicitWait(20).until(ExpectedConditions.visibilityOf(cop.covidTrackerTable()));
//		if (cop.covidTrackerTable().isDisplayed()) {
//			for (int i = 0; i < cop.stateNames().size(); i++) {
//				if (cop.stateNames().get(i).getText().equals("Kerala")) {
//					System.out.println(cop.confirmedCases().get(i).getText());
//					break;
//				}
//			}
//		}

		if (cop.covidTrackerTable().isDisplayed()) {
			int index = 0;
			for (WebElement stateName : cop.stateNames()) {
				try
				{
				index++;
				System.out.println(stateName.getText() + " : " + cop.confirmedCases().get(index).getText());
				}
				catch(IndexOutOfBoundsException e)
				{
					System.out.println(e.getMessage());
				}
				
				finally
				{
					System.out.println("Finally block executed after Catch block");
				}
				
			}
		}
		extent.flush();
	}

	@AfterTest
	public void Teardown() {
		driver.close();
	}

}
