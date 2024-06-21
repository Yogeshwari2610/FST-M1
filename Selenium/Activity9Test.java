package examples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity9Test {

	public static void main(String[] args) {
		// Setup the driver
        WebDriverManager.firefoxdriver().setup();
        // Driver object reference
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/ajax");

        driver.findElement(By.className("Violet")).click();
        String headingText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))).getText();
        System.out.println("New heading is: " + headingText);
        wait.until(ExpectedCondition.textToBePrestentInElementLocated(By.tagName("h3"),"I am Late!");
        String lateText = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Late text is : " + lateText);
        
        driver.quit();
        
        
	}

}
