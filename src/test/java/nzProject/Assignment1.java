package nzProject;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Assignment1 extends BaseClass{
	
	@Test
	public void test() {
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
	}

}
