package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
	AndroidDriver driver;
    WebDriverWait wait;
    
	@BeforeClass
	public void setUp() throws MalformedURLException{
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.contacts");
		options.setAppActivity("com.android.contacts.activities.PeopleActivity");
		options.noReset();
		
		//server address
		URL serverURL = new URL("http://localhost:4723/");	
		//driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	@Test
	public void addContact() {
		driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text='First name']")));
		
		//Enter details
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Ram");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Bujji");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("1234567890");
		
		//Click save option
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='com.google.android.contacts:id/toolbar_button']")).click();
		
		//Wait until contact save
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_title")));
		
		//Assertion
		String contact = driver.findElement(AppiumBy.id("large_title")).getText();
		Assert.assertEquals(contact, "Ram Bujji");
	}
	 @AfterClass
	    public void tearDown() {
	        // Close the app
	        driver.quit();
	    }
}