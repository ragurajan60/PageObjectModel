package TestCases;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepository.participantHomePage;
import ObjectRepository.participantLoginPage;
import Resources_Global.base;

public class PrimaryNavigation extends base {

	public static WebDriver driver;
	participantLoginPage PLP;
	participantHomePage PHP;
	private static Logger Log = LogManager.getLogger(ParticipantLogin.class.getName());

	@BeforeTest
	public void Initialize() throws IOException {
		//driver = InitializeDriver();
		Log.debug("Chrome Browser is Launched Successfully");
		driver.manage().window().maximize();
		Log.info("Chrome Browser Maximized Successfully");
		PLP = new participantLoginPage(driver);
		PHP = new participantHomePage(driver);
	}

	@Test
	public void PrimaryNavigationTest() throws IOException {
		driver.get(getProperty("URL"));
		Log.error("Successfully Navigated to URL: " + getProperty("URL"));
		PLP.UserId().sendKeys(getProperty("UserId"));
		PLP.Password().sendKeys(getProperty("Password"));
		PLP.VPNCheckBox().click();
		PLP.TestCfg1().sendKeys(getProperty("TestCfg1"));
		PLP.TestCfg2().sendKeys(getProperty("TestCfg2"));
		PLP.SkipCheckbox().click();
		PLP.LoginBtn().click();
//		PHP.GmcCloseBtn().click();
		List<String> PrimaryNavLinkId = PHP.PrimaryNav().stream().map(primnav -> primnav.getAttribute("href"))
				.map(primnav -> primnav.substring(primnav.indexOf("linkId") + 7, primnav.indexOf("&")))
				.collect(Collectors.toList());
		// PrimaryNavHref.forEach(ele -> System.out.println(ele));
		List<WebElement> PrimaryNav = PHP.PrimaryNav();
//		for(WebElement PrimNav : PrimaryNav)
//		{
//			PrimNav.click();
//			driver.getCurrentUrl().contains(PrimaryNavLinkId.get(PrimNav));
//		}

		for (int i = 0; i < PrimaryNav.size(); i++) {
			PrimaryNav.get(i).click();
			System.out.println("LinkId: " + PrimaryNavLinkId.get(i));
			System.out.println("Current URL: "+driver.getCurrentUrl());
			driver.getCurrentUrl().contains(PrimaryNavLinkId.get(i));
		}
		PHP.LogOffLink().click();
		SetExplicitWait(20).until(ExpectedConditions.visibilityOf(PLP.LogonAgainBtn()));
	}

	@AfterTest
	public void Teardown() {
		driver.close();
	}

}
