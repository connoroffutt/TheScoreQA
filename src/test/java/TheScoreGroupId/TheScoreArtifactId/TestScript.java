package TheScoreGroupId.TheScoreArtifactId;


import org.testng.annotations.Test;

import TheScoreGroupId.TheScoreArtifactId.PageObjects;

public class TestScript extends BaseTestFeatures{

	
	@Test
	public void theScoreLeagueSelection()  
	{
		PageObjects pageObjects = new PageObjects(driver);
		
		pageObjects.clickLogIn();
		pageObjects.enterUserNamePassword("connoroffuttqa@gmail.com", "Testpassword123!");
		pageObjects.dismissPopup.click();
		pageObjects.dismissLocationPopup.click();
	}
	
}
