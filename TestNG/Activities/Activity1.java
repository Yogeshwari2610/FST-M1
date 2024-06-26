package activities;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
public class Activity1 {
	WebDriver driver;
	
	@BeforeClass
	  public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		//open page
		driver.get("https://v1.training-support.net/");
	  }
	
  @Test(priority= 1)
  public void Homepage() throws InterruptedException {
	  String pageTitle = driver.getTitle();
	  Assert.assertEquals(pageTitle, "Training Support");
	 
	  //get the about us text and click onit
	  driver.findElement(By.id("about-link")).click();
	  Thread.sleep(2000);
	 
  }
  @Test(priority= 2)
  public void AboutUspage() {
	
	  Assert.assertEquals(driver.getTitle(), "About Training Support");
	  System.out.println("Title page of About :" + driver.getTitle());
	 
	 
  }
	  
  @AfterClass
  public void afterClass() {
	  //close the browser
	  driver.quit();
  }
}