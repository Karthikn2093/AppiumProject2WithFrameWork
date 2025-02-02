package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils{
	
	AndroidDriver driver;

	public AndroidActions(AndroidDriver driver) {
		super();
		this.driver = driver;
	}

	public void scrollUntil(String text) {

		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));

	}

	public void longClickGesture(WebElement ele) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));

	}

	public void scrollGestureUsingUiAutomator(String text) {

		// driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new
		// UiSelector()).scrollIntoView(text(\"WebView\"));"));
		driver.findElement(AppiumBy
				.androidUIAutomator("new uiScrollable(new uiSelector().scrollIntoView(text(\"" + text + "\"));"));
	}

	public void scrollGestureToEnd() {

		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 1.0));

		} while (canScrollMore);
	}

	public void swipe(WebElement ele, String direction) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.75));

	}

	public void DragNDrop(WebElement element, int x, int y) {

		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", x, "endY", y));

	}

}
