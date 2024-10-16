package nzProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DragNDrop extends BaseClass{
	
	@Test
	public void dragNDrop() throws Exception {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		DragNDrop(source,654,654);
		
		Thread.sleep(3000);
		
		String textResult = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		
		Assert.assertEquals(textResult, "Dropped!");
		
	}

}
