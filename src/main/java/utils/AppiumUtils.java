package utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class AppiumUtils {
	
	public AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startAppiumServer(String ipaddress, int port) {
		
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Karthik\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipaddress).usingPort(port).build();
		service.start();
		return service;
		
	}

	
	public double getFormattedAmount(String amountString) {

		return Double.parseDouble(amountString.substring(1));

	}
	
	public void waitForElementToAppear(WebElement element, AppiumDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((element), "text", "Cart"));
		
	}
	public List<HashMap<String,String>> getJSONData() throws Exception {
	String jsonContent = FileUtils.readFileToString(new File("C:\\Users\\Karthik\\eclipse-workspace\\AppiumProject2WithFrameWork\\src\\test\\java\\testData\\eCommerceLogin.json"), StandardCharsets.UTF_8);
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String, String>> data = mapper.readValue(jsonContent, 
			new TypeReference<List<HashMap<String, String>>>(){	
	});
	return data;
	}

	public String getScreenshotpath(String testCaseName, AppiumDriver driver) throws Exception {
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile =System.getProperty("user.dir") + "\\reports" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
