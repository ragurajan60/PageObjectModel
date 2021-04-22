package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationTestPages {
	static WebDriver driver;
	
	public AutomationTestPages(WebDriver driver)
	{
		AutomationTestPages.driver = driver;
		PageFactory.initElements(AutomationTestPages.driver, this);
	}

	@FindBy(xpath="//body")
	WebElement PrivacyTerms;
	
	@FindBy(xpath="//iframe")
	List<WebElement> iFrames;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Password')]")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath="//button[contains(text(),'Hover Over Me First!')]")
	WebElement mouseHoverDropdown;
	
	@FindBy(xpath="//button[contains(text(),'Hover Over Me First!')]/following-sibling::div/a")
	WebElement mouseHoverDropdownLink;
	
	@FindBy(xpath="//input[@id='myFile']")
	WebElement uploadDocBtn;
	
	@FindBy(id="submit-button")
	WebElement submitUploadDocBtn;
	
	@FindBy(xpath="//div[@data-id='MOBFUEPQEEDFBHCE']//a")
	WebElement realmeC12Silver;
	
	@FindBy(id="productRating_LSTMOBFZ2QW3ZA64BFVAZEHPS_MOBFZ2QW3ZA64BFV_")
	WebElement realmeC12SilverRatings;
	
	@FindBy(xpath="//div[@data-id='MOBFUEPQHDPFKKQT']//a")
	WebElement realmeC12Blue;
	
	
	
	public WebElement PrivacyTerms()
	{
		return PrivacyTerms;
	}
	
	public List<WebElement> iFrames()
	{
		return iFrames;
	}
	
	public WebElement forgotPasswordLink()
	{
		return forgotPasswordLink;
	}
	
	public WebElement mouseHoverDropdown()
	{
		return mouseHoverDropdown;
	}
	
	public WebElement mouseHoverDropdownLink()
	{
		return mouseHoverDropdownLink;
	}
	
	public WebElement uploadDocBtn()
	{
		return uploadDocBtn;
	}
	
	public WebElement submitUploadDocBtn()
	{
		return submitUploadDocBtn;
	}
	
	public WebElement realmeC12Silver()
	{
		return realmeC12Silver;
	}
	
	public WebElement realmeC12Blue()
	{
		return realmeC12Blue;
	}
	
	public WebElement realmeC12SilverRatings()
	{
		return realmeC12SilverRatings;
	}
}
