package eCommerce;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.Android.CartPage;
import pageObjects.Android.HomePage;
import pageObjects.Android.ProductsPage;
import testUtils.BaseClass;



public class Test1 extends BaseClass{
	
	@Test(dataProvider = "testData", groups ="Smoke")
	public void test1(String name, String gender, String country) throws Exception {
		
		homePage.setName(name).setGender(gender).setCountry(country).clickShop()
		.addItemToCart(0).addItemToCart(0).clickCartIcon();
		
		Thread.sleep(2000);
		
		CartPage cartPage = new CartPage(driver);
		
		double totalSum = cartPage.getTotalSum();
		double actualPrice = cartPage.getActualPrice();
		
		Assert.assertEquals(totalSum, actualPrice);
		
		cartPage.termsCase().checkBox().shopButton();
		
	}
	
	@DataProvider(name = "testData")
	public Object[][] testData(){
		
		//Object[][] testData = new Object[2][2];
		return new Object[][] { {"John","female","Algeria"}, 
		{"David","male","Albania"} };
		
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void preSetup() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK) );
	}


}
