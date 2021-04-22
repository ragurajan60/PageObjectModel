package ObjectRepository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Covid19OrgPage {
	
	public static WebDriver driver;
	private static Logger Log = LogManager.getLogger(participantLoginPage.class.getName());
	
	public Covid19OrgPage(WebDriver driver)
	{
		Covid19OrgPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div/div[@class='table fadeInUp']")
	WebElement covidTrackerTable;
	
	@FindBy(xpath="//div[@class='row']/div/div[contains(@class,'state-name')]")
	List<WebElement> stateNames;
	
	@FindBy(xpath="//div[@class='row']/div/div[@class='delta is-confirmed']/following-sibling::div")
	List<WebElement> confirmedCases;
	
	@FindBy(xpath="//div[@class='row']/div/div[@class='delta is-confirmed']/parent::div/following-sibling::div[1]/div")
	List<WebElement> activeCases;
	
	
	public WebElement covidTrackerTable()
	{
		return covidTrackerTable;
	}
	
	public List<WebElement> stateNames()
	{
		return stateNames;
	}
	
	public List<WebElement> confirmedCases()
	{
		return confirmedCases;
	}
	
	public List<WebElement> activeCases()
	{
		return activeCases;
	}
	
}
