package TheScoreGroupId.TheScoreArtifactId;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TheScoreGroupId.TheScoreArtifactId.PageObjects;

public class TestScript extends BaseTestFeatures{

	@DataProvider
	public Object[][] GetDataLeague()
	{
		return new Object [][] {{"Arsenal", "STATS (EPL)"}};
	}
	
	
	@Test(dataProvider="GetDataLeague")
	public void theScoreLeagueSelection(String team, String statHeaderExpected1)  
	{
		PageObjects pageObjects = new PageObjects(driver);
		
		pageObjects.clickLogIn();
		pageObjects.enterUserNamePassword("connoroffuttqa@gmail.com", "Testpassword123!");
		pageObjects.dismissPopup.click();
		pageObjects.dismissLocationPopup.click();
		pageObjects.searchAndSelectTeam(team);
		String teamTitle = pageObjects.teamName.getText();
		Assert.assertEquals(teamTitle, team);  //validate that the team we have selected is correct
		System.out.print(teamTitle + " = " + team);
		pageObjects.teamStats.click();
		String teamTitleStatsPage = pageObjects.teamName.getText();
		Assert.assertEquals(teamTitleStatsPage, team);  //validate we are still on the same team's stat page
		String statHeaderActual1 = pageObjects.teamStatType1.getText();
		Assert.assertEquals(statHeaderActual1, statHeaderExpected1);
		
		
	}
	
}
