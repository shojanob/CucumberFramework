package com.neotech.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods {

//	LoginPageElements login;
//	DashboardPageElements dashboard;

	@Given("I navigated to the HRM website")
	public void i_navigated_to_the_hrm_website() {
		setUp();
//		login = new LoginPageElements();
//		dashboard = new DashboardPageElements();
	}

	@When("I enter a valid username")
	public void i_enter_a_valid_username() {
		sendText(login.username, ConfigsReader.getProperty("username"));
	}

	@When("I enter a valid password")
	public void i_enter_a_valid_password() {
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		click(login.logInButton);
	}

	@Then("I validate that I am logged in")
	public void i_validate_that_i_am_logged_in() {

		String expected = "Jacqueline White";
		String actual = dashboard.accountName.getText();

		if (actual.equals(expected)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}

	}

	@Then("I will quit the browser")
	public void i_will_quit_the_browser() {
		tearDown();
	}

	@When("I enter an invalid password")
	public void i_enter_an_invalid_password() {
		sendText(login.password, "Horosho");
	}

	@Then("I validate that Invalid Credentials is displayed")
	public void i_validate_that_invalid_credentials_is_displayed() {
		String expectedMsg = "Invalid Credentials";
		String actualMsg = login.invalidMsg.getText();

		if (actualMsg.equals(expectedMsg)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
		}
	}

	@Given("user is logged in with valid credentials")
	public void user_is_logged_in_with_valid_credentials() {
		// This is done in the Hooks
		// setUp();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.logInButton);
	}

	@When("user enters login information {string} and {string}")
	public void user_enters_login_information_and(String username, String password) {
		sendText(login.username, username);
		sendText(login.password, password);

		wait(2);

	}

	@Then("verify that the {string} is shown")
	public void verify_that_the_is_shown(String expectedAccountName) {
		String actualAccountName = dashboard.accountName.getText();

		Assert.assertEquals("The account name did not match!", expectedAccountName, actualAccountName);

	}

	@When("user enters username and password and clicks on the login button")
	public void loginUsingDataTable(DataTable dataTable) {

		// we have all of our data here

		// TODO for all the rows of the data table
		// send login credentials
		// click login button
		// verify
		// logout --- sends us back to the login screen and ready for the next data to
		// test

		// get the data in a list of maps
		List<Map<String, String>> listOfMaps = dataTable.asMaps();

		System.out.println(listOfMaps);

		// loop on each map (because each map gives us a user)
		for (Map<String, String> map : listOfMaps) {
			System.out.println("Testing: " + map.get("username") + " : " + map.get("password"));
			// login
			sendText(login.username, map.get("username"));
			sendText(login.password, map.get("password"));

			click(login.logInButton);

			wait(1);

			// take a screenshot

			// validate
			String actualAccountName = dashboard.accountName.getText();

			Assert.assertEquals(map.get("employeeName"), actualAccountName);

			// logout
			dashboard.accountMenu.click();
			dashboard.logout.click();

		}

	}

}
