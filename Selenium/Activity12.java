package activities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity12 {

	public static void main(String[] args) {
		// Set up Edge driver
        WebDriverManager.edgedriver().setup();
        // Create a new instance of the Edge driver
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();


        // Open the page
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find the text field
        WebElement textbox = driver.findElement(By.id("input-text"));
        // Check if it is enabled
        System.out.println("Input field is enabled: " + textbox.isEnabled());
        // Click the toggle button to enable it
        driver.findElement(By.id("toggleInput")).click();
        // Check if the text field is enabled
        System.out.println("Input field is enabled: " + textbox.isEnabled());

        // Close the browser
        driver.close();

	}

}