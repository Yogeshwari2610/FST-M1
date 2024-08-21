package Activities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {
 WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	//Setup Edge driver
	  WebDriverManager.edgedriver().setup();
	  //Initialize driver
	  driver = new EdgeDriver();
	  //open the page
	  driver.get("https://v1.training-support.net/selenium/target-practice");
  }

  @Test
  public void test1() {
	  //get title of the page
	  String title = driver.getTitle();
	  System.out.println("page Title :"+title);
	  Assert.assertEquals(title, "Target Practice");  
  }
  @Test
  public void test2() {
	  WebElement color=driver.findElement(By.cssSelector("button.black"));
      Assert.assertEquals(color.getText(), "black");
  }
  @Test(enabled = false)
  public void test3() {
	  System.out.println("This method is skipped");
	  
  }
  @Test
  public void test4() {
	  throw new SkipException("This 4th method is skipped");
  }
  
  @AfterClass
  public void afterClass() {
	  //close driver
	  driver.close();
  }

}