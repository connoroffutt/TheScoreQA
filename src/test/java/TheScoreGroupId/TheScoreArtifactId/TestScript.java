package TheScoreGroupId.TheScoreArtifactId;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import TheScoreGroupId.TheScoreArtifactId.PageObjects;

public class TestScript extends BaseTestFeatures{

	@DataProvider
	public Object[][] GetDataLeague()
	{
		return new Object [][] {{"Arsenal", "STATS (EPL)", "Tackles Succeeded"},
			{"Detroit Lions","OFFENSE STATS","Total Yards"},
			{"Toronto Raptors", "STATS", "Pythagorean Wins"}
		};
	}
	
	
	@Test(dataProvider="GetDataLeague")
	public void theScoreLeagueSelection(String team, String statHeaderExpected1, String statHeaderExpected2)  
	{
		PageObjects pageObjects = new PageObjects(driver);
		
		//pageObjects.clickLogIn();
		pageObjects.continueButton.click();
		//pageObjects.enterUserNamePassword("connoroffuttqa@gmail.com", "Testpassword123!");
		pageObjects.continueButton.click();		
		pageObjects.dismissLocationPopup.click();
		pageObjects.searchFavTeam(team);
		pageObjects.dismissPopup.click();
		pageObjects.searchAndSelectTeam(team);
		String teamTitle = pageObjects.teamName.getText();
		Assert.assertEquals(teamTitle, team);  //validate that the team we have selected is correct
		System.out.print(teamTitle + " = " + team);
		pageObjects.teamStats.click();
		String teamTitleStatsPage = pageObjects.teamName.getText();
		Assert.assertEquals(teamTitleStatsPage, team);  //validate we are still on the same team's stat page
		String statHeaderActual1 = pageObjects.teamStatType1.getText();
		Assert.assertEquals(statHeaderActual1, statHeaderExpected1);
		pageObjects.scrollToElement(statHeaderExpected2); //scrolls to find stat if not available on screen
		pageObjects.validateTeamStats(statHeaderExpected2);
		pageObjects.backButton.click();
		String validateSearchReturn = pageObjects.firstSearchResult.getText();
		Assert.assertEquals(validateSearchReturn, team);
		pageObjects.backButton.click();
		boolean homePageReturnSuccess = pageObjects.favouritesTab.isEnabled();
		Assert.assertEquals(homePageReturnSuccess, true);
	}
	
}
