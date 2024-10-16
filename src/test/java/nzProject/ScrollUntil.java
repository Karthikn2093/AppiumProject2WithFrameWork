package nzProject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollUntil extends BaseClass{
	
	@Test
	public void scrollingTest() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		scrollUntil("WebView");
		
	}

}
