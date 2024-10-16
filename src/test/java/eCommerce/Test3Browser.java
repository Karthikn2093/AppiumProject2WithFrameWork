package eCommerce;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.Android.HomePage;
import testUtils.BaseClass;

public class Test3Browser extends BaseClass {

	@Test
	public void test3() throws Exception {

		String country = "Algeria";

		homePage.setName("John").setGender("Female").setCountry(country).clickShop().
		addItemToCart(0).clickCartIcon()
		.checkBox().shopButton();
		
		Thread.sleep(5000);
		
		driver.getContextHandles();
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		
		driver.findElement(By.name("q")).sendKeys("Karthik" + Keys.ENTER);
		
		Thread.sleep(2000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.context("NATIVE_APP");
		
	}

}
