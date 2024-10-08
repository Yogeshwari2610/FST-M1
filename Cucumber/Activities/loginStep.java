package stepDefinitions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginStep extends BaseClass{

	
	@BeforeAll
	
	public static void setUp() {
		WebDriverManager.firefoxdriver().setup();
		
		driver = new FirefoxDriver();
		
	}
	
	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
	

	
	@Given("the user is on the login page")
	public void openPage() {
		driver.get("https://v1.training-support.net/selenium/login-form");
		
		Assertions.assertEquals("Login Form", driver.getTitle());
	}
	
	@When("the user enters username and password")
	public void enterCredentials() {
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.id("password")).sendKeys("password");
}

	@When("the user enters {string} and {string}")
	public void enterCredentialsFromInputs(String username, String password) {
		
		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));
		
		usernameField.clear();
		passwordField.clear();
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		
		
	}
	
	@And("clicks the submit button")
	public void clickSubmit() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	@Then("get the confirmation text and verify message")
public void confirmMessage() {
		String message = driver.findElement(By.id("action-confirmation")).getText();
		Assertions.assertEquals("Welcome Back,admin", message);
				}
	
	@Then("get the confirmation text and verify message as {string}")
	
	public void confirmMessageAsInput(String expectedMessage) {
		String message = driver.findElement(By.id("action-confirmation")).getText();
		Assertions.assertEquals(expectedMessage, message);
		}
	
	
	

}
