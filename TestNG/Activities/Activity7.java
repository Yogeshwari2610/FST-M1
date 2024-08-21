package Activities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity7 {
	WebDriver driver;
  @BeforeClass
  public void setUp() {
	  //Setup Edge driver
	  WebDriverManager.edgedriver().setup();
	  //Initialize driver
	  driver = new EdgeDriver();
	  //open the page
	  driver.get("https://v1.training-support.net/selenium/login-form");
  }
  
  @DataProvider(name="credentials")
  public static Object[][] creds(){
	  return new Object[][] {
		  {"admin","password","Welcome Back, admin"},
		  {"wrongAdmin","wrongPassword","Invalid Credentials"}
	  };
  }

  @Test(dataProvider = "credentials")
  public void loginTest(String username, String password, String expectedMessage) {
	  //Find input fields & login button
	  WebElement usernamefield =driver.findElement(By.id("username"));
	  WebElement passwordfield =driver.findElement(By.id("password"));
	  WebElement loginButton =driver.findElement(By.xpath("//button[text()='Log in']"));
	  
	  //clear input fields
	  usernamefield.clear();
	  passwordfield.clear();
	  //enter values for login
	  usernamefield.sendKeys(username);
	  passwordfield.sendKeys(password);
	  loginButton.click();
	  //Assert login message
	  String confirmationMessage = driver.findElement(By.id("action-confirmation")).getText();
	  Assert.assertEquals(confirmationMessage, expectedMessage);
  }
  
  @AfterClass
  public void teardown() {
	  //Close driver
	  driver.quit();
  }

}