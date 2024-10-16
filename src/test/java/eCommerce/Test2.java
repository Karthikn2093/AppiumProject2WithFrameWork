package eCommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import pageObjects.Android.HomePage;
import testUtils.BaseClass;

public class Test2 extends BaseClass{
	
	@Test
	public void negativeFlow() {
		
		homePage.setGender("Male").setCountry("Albania").clickShop();
		homePage.verifyToast();
		
	}
	
	@Test
	public void positiveFlow() {
		
		homePage.setGender("Male").setCountry("Albania").setName("Jenny").clickShop();
		
	}
	
	

}
