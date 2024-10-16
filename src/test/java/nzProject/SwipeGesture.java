package nzProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SwipeGesture extends BaseClass {
	
	@Test
	public void swipeGesture() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		WebElement firstElement = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
		Assert.assertEquals(firstElement.getAttribute("focusable"), "true");
		
		swipe(firstElement, "left");
		
		Assert.assertEquals(firstElement.getAttribute("focusable"), "false");
		
	}

}
