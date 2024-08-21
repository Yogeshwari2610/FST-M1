package Activities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	//Setup Edge driver
	  WebDriverManager.edgedriver().setup();
	  //Initialize driver
	  driver = new EdgeDriver();
	  //open the page
	  driver.get("https://v1.training-support.net/selenium/login-form");
  }

  @Test
  public void login() {
	  WebElement username = driver.findElement(By.id("username"));
      WebElement password = driver.findElement(By.id("password"));
      //Pass cred
      username.sendKeys("admin");
      password.sendKeys("password");
	  //login button
      driver.findElement(By.xpath("//button[text()='Log in']")).click();
      //Read login message
      String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
      Assert.assertEquals("Welcome Back, admin", loginMessage);
  }
  
  @AfterClass
  public void afterClass() {
	  //CLOSE DRIVER
	  driver.close();
  }

}