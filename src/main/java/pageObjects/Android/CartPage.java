package pageObjects.Android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class CartPage extends AndroidActions {

	AndroidDriver driver;

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement actualPrice;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement termsButton;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/alertTitle")
	private WebElement termsTitle;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement termsOK;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement checkBox;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement shopButton;

	public double getTotalSum() {

		double totalSum = 0;

		for (int i = 0; i < 2; i++) {

			String amountString = productList.get(i).getText();
			double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;

		}
		
		return totalSum;

	}
	
	public double getActualPrice() {
		
		String actualPriceString = actualPrice.getText();
		double actualPrice = getFormattedAmount(actualPriceString);
		return actualPrice;
		
	}
	
	public CartPage termsCase() {
		
		longClickGesture(termsButton);
		
		String alertTitle = termsTitle.getText();
		
		Assert.assertEquals(alertTitle, "Terms Of Conditions");
		
		termsOK.click();
		
		return this;
	}
	
	public CartPage checkBox() {
		checkBox.click();
		return this;
	}
	
	public void shopButton() {
			
		shopButton.click();
	}

}
