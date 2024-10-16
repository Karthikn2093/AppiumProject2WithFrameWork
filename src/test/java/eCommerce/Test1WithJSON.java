package eCommerce;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.Android.CartPage;
import testUtils.BaseClass;

public class Test1WithJSON extends BaseClass{
	
	@Test(dataProvider = "testDataJSON")
	public void test1(HashMap<String, String> input) throws Exception {
		
		homePage.setName(input.get("name")).setGender(input.get("Gender")).setCountry(input.get("country")).clickShop()
		.addItemToCart(0).addItemToCart(0).clickCartIcon();
		
		Thread.sleep(2000);
		
		CartPage cartPage = new CartPage(driver);
		
		double totalSum = cartPage.getTotalSum();
		double actualPrice = cartPage.getActualPrice();
		
		Assert.assertEquals(totalSum, actualPrice);
		
		cartPage.termsCase().checkBox().shopButton();
		
	}
	
	@DataProvider(name = "testDataJSON")
	public Object[][] testDataJSON() throws Exception{
		List<HashMap<String, String>> jsonData = getJSONData();
		return new Object[][] { {jsonData.get(0)}, 
		{jsonData.get(1)} };
		
	}
	
	@BeforeMethod
	public void preSetup() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK) );
	}

}
