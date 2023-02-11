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
	
}
