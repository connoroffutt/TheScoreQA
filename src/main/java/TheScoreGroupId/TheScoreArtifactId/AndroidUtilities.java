package TheScoreGroupId.TheScoreArtifactId;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
public class AndroidUtilities {

	AndroidDriver driver;
	
	public AndroidUtilities(AndroidDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickLogIn()
	{				
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.fivemobile.thescore:id/action_button_text")));
		((JavascriptExecutor)driver).executeScript("mobile: clickGesture", 
				ImmutableMap.of(
						"x", 965, "y", 2382											
						));
	}
	
	public void scrollToElement(String ele)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"+".scrollIntoView(textContains(\""+ele+"\"))"));
	}
	
}