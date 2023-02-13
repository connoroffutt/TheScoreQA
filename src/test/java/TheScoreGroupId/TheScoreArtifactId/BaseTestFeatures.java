package TheScoreGroupId.TheScoreArtifactId;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTestFeatures {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		
		//code to start Appium server - must point this service at your main.js file for test to work
			service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\conno\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("0.0.0.0").usingPort(4723).build();
			service.start();
	}
	
	@BeforeMethod
	public void preSetup() throws MalformedURLException
	{
			//code to start driver with UiAutomator options and set implicit wait
			UiAutomator2Options options = new UiAutomator2Options();
			String path = System.getProperty("user.dir");			
			System.out.print("DIRECTORY: " + path + " ");
			options.setDeviceName("Pixel 6 Pro Emulator");
			options.setApp(path + "\\com.fivemobile.thescore_23.1.0-23010_minAPI24(arm64-v8a,armeabi-v7a,x86,x86_64)(nodpi)_apkmirror.com.apk");		
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void postSetup()
	{
		//stop driver after test
		driver.quit();
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException 
	{
		//stop server after all tests complete
		Thread.sleep(2000);
		service.stop();
	}
	
}