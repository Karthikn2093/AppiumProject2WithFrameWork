package nzProject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Scrolling extends BaseClass{
	
	@Test
	public void scrollingTest() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//scrollGestureUsingUiAutomator("WebView");
		
		WebElement webViewElement = driver.findElement(AppiumBy.accessibilityId("WebView"));
		
		boolean canScrollMore;
		do {
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 1.0
			));
		 
	}while(canScrollMore);
	}
		
		
		
	}


