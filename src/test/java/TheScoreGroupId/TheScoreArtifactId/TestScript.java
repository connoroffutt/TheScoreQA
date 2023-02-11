package TheScoreGroupId.TheScoreArtifactId;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TheScoreGroupId.TheScoreArtifactId.PageObjects;

public class TestScript extends BaseTestFeatures{

	@DataProvider
	public Object[][] GetDataLeague()
	{
		return new Object [][] {{"Arsenal"}};
	}
	
	
	@Test(dataProvider="GetDataLeague")
	public void theScoreLeagueSelection(String team)  
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
	}
	
}
