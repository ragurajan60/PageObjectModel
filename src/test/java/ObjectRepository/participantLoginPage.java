package ObjectRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class participantLoginPage {

	public static WebDriver driver;
	private static Logger Log = LogManager.getLogger(participantLoginPage.class.getName());

	public participantLoginPage(WebDriver driver) {
		participantLoginPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "_ParticipantLogon20_WAR_ahcommonauthportlet_userId")
	WebElement UserId;

	@CacheLookup
	@FindBy(id = "_ParticipantLogon20_WAR_ahcommonauthportlet_password")
	WebElement Password;

	@FindBy(id = "_ParticipantLogon20_WAR_ahcommonauthportlet_enableNPVCheckbox")
	WebElement VPNCheckBox;

	@FindBy(id = "_ParticipantLogon20_WAR_ahcommonauthportlet_testCfgList[0].cfgValue")
	WebElement TestCfg1;

	@FindBy(id = "_ParticipantLogon20_WAR_ahcommonauthportlet_testCfgList[1].cfgValue")
	WebElement TestCfg2;

	@FindBy(id = "_ParticipantLogon20_WAR_ahcommonauthportlet_testCfgList[2].cfgValue")
	WebElement TestCfg3;

	@FindBy(id = "_ParticipantLogon20_WAR_ahcommonauthportlet_skipAACheckbox")
	WebElement SkipCheckbox;

	@FindBy(id = "_ParticipantLogon20_WAR_ahcommonauthportlet_udpSchema")
	WebElement UDPSchema;

	@FindBy(id = "_ParticipantLogon20_WAR_ahcommonauthportlet_logOn")
	WebElement LoginBtn;

	@FindBy(id = "logonAgain")
	WebElement LogonAgainBtn;
	
	public WebElement User() {
		return driver.findElement(By.id("_ParticipantLogon20_WAR_ahcommonauthportlet_userId"));
	}

	public WebElement UserId() {
		Log.debug("Found Element: " + UserId);
		return UserId;
	}
	
	public WebElement Pass() {
		return driver.findElement(By.id("_ParticipantLogon20_WAR_ahcommonauthportlet_password"));
	}

	public WebElement Password() {
		Log.fatal("Found Element: " + Password);
		return Password;
	}

	public WebElement VPNCheckBox() {
		Log.always().log("Always Logging: " + VPNCheckBox);
		return VPNCheckBox;
	}

	public WebElement TestCfg1() {
		return TestCfg1;
	}

	public WebElement TestCfg2() {
		return TestCfg2;
	}

	public WebElement TestCfg3() {
		return TestCfg3;
	}

	public WebElement SkipCheckbox() {
		return SkipCheckbox;
	}

	public WebElement UDPSchema() {
		return UDPSchema;
	}

	public WebElement LoginBtn() {
		return LoginBtn;
	}

	public participantHomePage LoginBtnClick() {
		LoginBtn.click();
		return new participantHomePage(driver);

	}

	public WebElement LogonAgainBtn() {
		return LogonAgainBtn;
	}
}
