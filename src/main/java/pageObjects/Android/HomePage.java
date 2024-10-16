package pageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class HomePage extends AndroidActions {
	
	AndroidDriver driver;
	
	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement maleGender;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleGender;
	
	@AndroidFindBy(id = "android:id/text1")
	private WebElement clickCountryList;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	@AndroidFindBy(xpath ="//android.widget.Toast")
	private WebElement toastMsg;
	
	public HomePage setName(String name) {
		
		nameField.sendKeys(name);
		driver.hideKeyboard();
		return this;
	}
	
	public HomePage setGender(String gender) {
		
		if(gender.contains("Female")) {
			femaleGender.click();
		}else
			maleGender.click();
		return this;
		
	}
	
	public HomePage setCountry(String country) {
		
		clickCountryList.click();
		scrollUntil(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
		return this;
		
	}
	
	public ProductsPage clickShop() {
		
		shopButton.click();
		return new ProductsPage(driver);
		
	}
	
	public HomePage verifyToast() {
		
		String toastMessage = toastMsg.getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		return this;
	}
	
	public void setActivity() {
				((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
	}
	
}
