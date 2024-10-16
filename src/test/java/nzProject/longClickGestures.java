package nzProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class longClickGestures extends BaseClass {
	
	@Test
	public void longClickGestures() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		longClickGesture(ele);
		
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.id("android:id/title")).getText(),"Sample menu");
	}

}
