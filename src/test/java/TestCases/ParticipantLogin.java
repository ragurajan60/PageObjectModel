package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import ObjectRepository.*;
import Resources_Global.RetryAnalyzer;
import Resources_Global.base;

public class ParticipantLogin extends base {

	public static WebDriver driver;
	static SoftAssert softAssert;
	// public static RemoteWebDriver driver;
	// public static WebDriver driver;
	participantLoginPage PLP;
	participantHomePage PHP;
	AutomationTestPages ATP;
	private static Logger Log = LogManager.getLogger(ParticipantLogin.class.getName());
	ExtentReports extent;
	ExtentSparkReporter Spark;
	ExtentTest logger;
	String CurrPath = System.getProperty("user.dir");

	//@Parameters("browser")
	@BeforeTest
	public void Initialize() throws IOException {
		ExtentSparkReporter Spark = new ExtentSparkReporter(CurrPath + "//ExtentReports//ExtentReport.html");
		Spark.loadXMLConfig(CurrPath + "//Resources//extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(Spark);
		extent.setSystemInfo("Developer", "Ragurajan N");
		driver = InitializeDriver("chrome");
		Log.debug("Chrome Browser is Launched Successfully");
		driver.manage().window().maximize();
		Log.info("Chrome Browser Maximized Successfully");
		PLP = new participantLoginPage(driver);
		ATP = new AutomationTestPages(driver);
		// PHP = new participantHomePage(driver);
	}

	@Test
	public void ChromeParticipantLoginTest() throws Exception {
		softAssert = new SoftAssert();
		driver.get(getProperty("URL"));
		softAssert.assertEquals(driver.getTitle(), "Ragurajan");
		takeSnapShot("test",driver);
		System.out.println(driver.getTitle());
		Log.error("Successfully Navigated to URL: " + getProperty("URL"));
		/*
		 * WebElement UserId = PLP.UserId(); WebElement User = PLP.User();
		 * UserId.sendKeys(getProperty("UserId")); User.sendKeys(getProperty("UserId"));
		 */
		PLP.UserId().sendKeys(getProperty("UserId"));
		softAssert.assertEquals(PLP.UserId().getAttribute("id"), "Ragurajan");
		/*
		 * WebElement Password = PLP.Password(); WebElement Pass = PLP.Pass();
		 * Password.sendKeys(getProperty("Password"));
		 * Pass.sendKeys(getProperty("Password"));
		 */
		PLP.Password().sendKeys(getProperty("Password"));
		softAssert.assertEquals(PLP.Password().getAttribute("id"), "Ragurajan");
		PLP.VPNCheckBox().click();
		PLP.TestCfg1().sendKeys(getProperty("TestCfg1"));
		PLP.TestCfg2().sendKeys(getProperty("TestCfg2"));
		String skipCheckBoxName = PLP.SkipCheckbox().getAttribute("name");
		softAssert.assertEquals(skipCheckBoxName, "Ragurajan");
		// Assert.assertEquals(skipCheckBoxName, "Ragurajan");
		PLP.SkipCheckbox().click();
		// PHP = PLP.LoginBtnClick();
		/*
		 * if(PHP.GmcCloseBtn().size() > 0) { PHP.GmcCloseBtn().get(0).click(); }
		 * takeSnapShot("test1"); String PrimaryWindow = driver.getWindowHandle();
		 * PHP.PrivacyStatementLink().click(); Set<String> AllWindows =
		 * driver.getWindowHandles();
		 * 
		 * for(String Window : AllWindows) { if(!Window.equalsIgnoreCase(PrimaryWindow))
		 * { driver.switchTo().window(Window); driver.manage().window().maximize();
		 * System.out.println("Child Window Title: "+driver.getTitle());
		 * takeSnapShot("test2"); driver.close(); } }
		 * 
		 * driver.switchTo().window(PrimaryWindow);
		 * 
		 * PHP.HLPTab().click(); takeSnapShot("test3"); PHP.TakeActionSecNav().click();
		 * PHP.ChangeCoverageLink().click();
		 * driver.switchTo().frame("integrationIframe"); takeSnapShot("test4");
		 * System.out.println(PHP.ChangeCoverageTitle().getText());
		 * driver.switchTo().defaultContent(); PHP.LogOffLink().click(); logger =
		 * extent.createTest("ParticipantLoginTest"); logger.log(Status.PASS,
		 * "ParticipantLoginTest");
		 */
		extent.flush();
		softAssert.assertAll();
		/*
		 * SetExplicitWait(20).until(ExpectedConditions.visibilityOf(PLP.LogonAgainBtn()
		 * ));
		 */

	}

	/*
	 * @Test(enabled=false) public void ActionClassTest() throws IOException,
	 * InterruptedException { driver.get(getProperty("FlipkartURL"));
	 * 
	 * 
	 * List<WebElement> iFrames = ATP.iFrames();
	 * 
	 * if(iFrames != null) { for(int i=0; i<iFrames.size(); i++) {
	 * System.out.println(iFrames.get(i).getLocation());
	 * if(iFrames.get(i).getAttribute("title").equals("reCAPTCHA")) {
	 * driver.switchTo().frame(i); } } }
	 * 
	 * 
	 * Actions action = new Actions(driver);
	 * action.moveToElement(ATP.mouseHoverDropdown()).build().perform();
	 * System.out.println("X value: "+ATP.mouseHoverDropdown().getLocation().getX()
	 * + "Y value: " + ATP.mouseHoverDropdown().getLocation().getY());
	 * System.out.println("X value: "+ATP.mouseHoverDropdown().getLocation().x +
	 * "Y value: " + ATP.mouseHoverDropdown().getLocation().y); WebDriverWait
	 * webDriverWait = new WebDriverWait(driver, 20000);
	 * webDriverWait.until(ExpectedConditions.visibilityOf(ATP.
	 * mouseHoverDropdownLink()));
	 * action.moveToElement(ATP.mouseHoverDropdownLink()).perform();
	 * 
	 * 
	 * 
	 * ATP.uploadDocBtn().sendKeys("C:\\Users\\Admin\\Desktop\\TestData.txt");
	 * Thread.sleep(5000L); ATP.submitUploadDocBtn().click(); Thread.sleep(10000L);
	 * driver.switchTo().alert().accept();
	 * 
	 * 
	 * Thread.sleep(10000L); ATP.realmeC12Silver().click(); Thread.sleep(10000L);
	 * ATP.realmeC12Blue().click(); Thread.sleep(10000L);
	 * ATP.realmeC12Silver().sendKeys(Keys.CONTROL, Keys.TAB); Thread.sleep(10000L);
	 * System.out.println(ATP.realmeC12SilverRatings().getText());
	 * ATP.realmeC12SilverRatings().click(); Thread.sleep(10000L);
	 * ATP.realmeC12SilverRatings().sendKeys(Keys.CONTROL, Keys.SHIFT, Keys.TAB);
	 * Thread.sleep(10000L); ATP.realmeC12Blue();
	 * System.out.println(driver.getWindowHandle()); Actions action = new
	 * Actions(driver); action.keyUp(Keys.CONTROL, Keys.TAB);
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	@AfterTest
	public void Teardown() {

		try {
			softAssert.assertAll();
		} catch (java.lang.AssertionError e) {
			System.out.println(e.getMessage());
		}

		driver.quit();

	}
}
