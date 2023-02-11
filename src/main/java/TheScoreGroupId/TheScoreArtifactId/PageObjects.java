package TheScoreGroupId.TheScoreArtifactId;

import java.time.Duration;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;;

public class PageObjects extends TheScoreGroupId.TheScoreArtifactId.AndroidUtilities {

	AndroidDriver driver;
	

	public PageObjects(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	
	}
	//android page objects
	
	@AndroidFindBy(id="com.fivemobile.thescore:id/email_input_edittext")
	public WebElement userNameField;
	
	@AndroidFindBy(id="com.fivemobile.thescore:id/password_input_edittext")
	public WebElement passwordField;
		
	@AndroidFindBy(id="com.fivemobile.thescore:id/login_button")
	public WebElement logInButton;
	
	@AndroidFindBy(id="com.fivemobile.thescore:id/dismiss_modal")
	public WebElement dismissPopup;
	
	@AndroidFindBy(id="com.fivemobile.thescore:id/btn_disallow")
	public WebElement dismissLocationPopup;
	
	@AndroidFindBy(id="com.fivemobile.thescore:id/search_bar_text_view")
	public WebElement searchBar;
	
	@AndroidFindBy(id="com.fivemobile.thescore:id/search_src_text")
	public WebElement searchBarType;
	
	@AndroidFindBy(id="com.fivemobile.thescore:id/txt_name")
	public WebElement firstSearchResult;
	
	@AndroidFindBy(id="com.fivemobile.thescore:id/team_name")
	public WebElement teamName;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@content-desc=\"Team Stats\"]/android.widget.TextView")
	public WebElement teamStats;
	
	@AndroidFindBy(id="com.fivemobile.thescore:id/header_text")
	public WebElement teamStatType1;
	
	@AndroidFindBy(xpath="//*[contains(@text, 'Tackles Succeeded')]")
	public WebElement teamStatType2Arsenal;
	
	@AndroidFindBy(xpath="//*[contains(@text, 'Total Yards')]")
	public WebElement teamStatType2Lions;
	
	@AndroidFindBy(xpath="//*[contains(@text, 'Pythagorean Wins')]")
	public WebElement teamStatType2Raptors;
	
	
	//functionality
	public void enterUserNamePassword(String username, String password) 
	{
				
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		logInButton.click();
		driver.hideKeyboard();		
		
	}
	
	public void searchAndSelectTeam(String team)
	{
		searchBar.click();		
		searchBarType.sendKeys(team);
		firstSearchResult.click();		
		
	}
	
	public void validateTeamStats(String teamStats2)
	{
		if (teamStats2.equals("Tackles Succeeded")) 
		{
			String statHeader2Arsenal = teamStatType2Arsenal.getText();
			Assert.assertEquals(statHeader2Arsenal, teamStats2);
			System.out.print(statHeader2Arsenal + " Equals " + teamStats2 );  //validate the requested stat is available
			
		}
		else if (teamStats2.contains("Total Yards"))
		{
			String statHeader2Lions = teamStatType2Lions.getText();
			Assert.assertEquals(statHeader2Lions, teamStats2);
			System.out.print(statHeader2Lions + " Equals " + teamStats2 ); //validate the requested stat is available
			
		}	
		else if (teamStats2.contains("Pythagorean Wins"))	
		{
			String statHeader2Raptors = teamStatType2Raptors.getText();
			Assert.assertEquals(statHeader2Raptors, teamStats2);
			System.out.print(statHeader2Raptors + " equals = " + teamStats2); //validate the requested stat is available
			
		}
	}
	
}
