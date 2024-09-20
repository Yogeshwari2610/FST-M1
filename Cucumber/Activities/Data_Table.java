package stepdefinitions;


import java.util.List;

import org.openqa.selenium.By;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Data_Table extends baseclass {

	@Given("User completed Req")
	public void completeRequirement() {
		System.out.println("Given req is completed");
	}

	@When("User logins with below username and password")
	public void user_enters_and(DataTable credentials) {
		List<List<String>> creds = credentials.asLists();
		for (List<String> cred : creds) {
			for (String credential : cred) {
				System.out.println(credential);
			}
		}
		System.out.println(creds);
	}

	@When("User enters expected Tasks")
	public void inputTasks(DataTable inputTasks) {
		driver.get("https://v1.training-support.net/selenium/todo-list");
		List<String> tasks = inputTasks.asList();
		System.out.println(tasks);

		for(String task : tasks) {
			driver.findElement(By.id("taskInput")).sendKeys(task);
		}
	}

	@Then("Verify the results")
	public void verifyResults() {
		System.out.println("Result verification is completed");
	}
}