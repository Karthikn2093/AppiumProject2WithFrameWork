package testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pageObjects.Android.HomePage;
import utils.AppiumUtils;

public class BaseClass extends AppiumUtils{
	
	public AndroidDriver driver;
	public HomePage homePage;
	
	@BeforeClass(alwaysRun = true)
	public void startApp() throws MalformedURLException, URISyntaxException, IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Karthik\\eclipse-workspace\\AppiumProject2WithFrameWork\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String ipaddress = System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
		int port = Integer.parseInt(prop.getProperty("port"));
		service = startAppiumServer(ipaddress, port);
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setChromedriverExecutable("C:\\Users\\Karthik\\eclipse-workspace\\AppiumProject2\\src\\test\\java\\resources\\chromedriver.exe");
		options.setDeviceName("Pixel 4a");
		options.setApp("C:\\Users\\Karthik\\eclipse-workspace\\AppiumProject2\\src\\test\\java\\resources\\General-Store.apk");
		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homePage = new HomePage(driver);
	}
	
	@AfterClass(alwaysRun = true)
	public void closeApp() {
		
		driver.quit();
		service.stop();
		
	}
	
	/*
	 * @BeforeMethod public void presetup() { ((JavascriptExecutor)
	 * driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
	 * "com.androidsample.generalstore/com.androidsample.generalstore.MainActivity")
	 * ); }
	 */
	
	
}
