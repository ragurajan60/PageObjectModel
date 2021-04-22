package ObjectRepository;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.ParticipantLogin;

public class participantHomePage {
	
	public static WebDriver driver;
	private static Logger Log = LogManager.getLogger(ParticipantLogin.class.getName());
	
	public participantHomePage(WebDriver driver)
	{
		participantHomePage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="alDialogCloseBtn")
	List<WebElement> GmcCloseBtn;
	
	By RaguOffLink = By.xpath("//div[@id='al-aux-nav']//ul[@id='al-aux-nav-primary']//li/a[contains(text(),'Ragu Off')]");
	
//	@FindBy(xpath="//div[@id='al-aux-nav']//ul[@id='al-aux-nav-primary']//li/a[contains(text(),'Ragu Off')]")
//	WebElement RaguOffLink;
	
	@FindBy(xpath="//div[@id='al-aux-nav']//ul[@id='al-aux-nav-primary']//li/a[contains(text(),'Log Off')]")
	WebElement LogOffLink;
	
	@FindBy(xpath="//div[@id='al-primary-nav']//ul[@id='al-primary-expand-list']/li/a")
	List <WebElement> PrimaryNav;
	
	@FindBy(xpath="//ul[@id='furtherLinks']/li/a[contains(text(),'Privacy Statement')]")
	WebElement PrivacyStatementLink;
	
	@FindBy(xpath="//ul/li/a[contains(text(),'Health & Insurance')]")
	WebElement HLPTab;
	
	@FindBy(xpath="//ul/li/a[contains(text(),'Take Action')]")
	WebElement TakeActionSecNav;
	
	@FindBy(xpath="//ul/li/a[contains(text(),'Change Coverage')]")
	WebElement ChangeCoverageLink;
	
	@FindBy(xpath="//form//div/h1[1]")
	WebElement ChangeCoverageTitle;
	
	public List<WebElement> GmcCloseBtn()
	{
		return GmcCloseBtn;
	}
	
	public List <WebElement> PrimaryNav()
	{
		return PrimaryNav;
	}
	
	public WebElement PrivacyStatementLink()
	{
		return PrivacyStatementLink;
	}
	
	public WebElement RaguLogOffLink()
	{
		return driver.findElement(RaguOffLink);
	}
	
	public WebElement LogOffLink()
	{
		Log.debug("Found Element: "+LogOffLink);
		return LogOffLink;
	}
	
	public WebElement HLPTab()
	{
		return HLPTab;
	}
	
	public WebElement TakeActionSecNav()
	{
		return TakeActionSecNav;
	}
	
	public WebElement ChangeCoverageLink()
	{
		return ChangeCoverageLink;
	}
	
	public WebElement ChangeCoverageTitle()
	{
		return ChangeCoverageTitle;
	}
}
