package com.neotech.steps;

import org.junit.Assert;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployee extends CommonMethods {

	@Given("user navigates to AddEmployee page")
	public void user_navigates_to_add_employee_page() {
		click(dashboard.PIM);
		click(dashboard.addEmployeeLink);
	}

	// hardcoded step
	@When("user enters employee first name and last name")
	public void user_enters_employee_first_name_and_last_name() {
		sendText(addEmployee.firstName, "Lionel");
		sendText(addEmployee.lastName, "Messi");
	}

	// parametrized step
	@When("user enters employee first name {string} and last name {string}")
	public void user_enters_employee_first_name_and_last_name(String firstName, String lastName) {
		sendText(addEmployee.firstName, firstName);
		sendText(addEmployee.lastName, lastName);
	}

	@When("user selects a location")
	public void user_selects_a_location() {
		selectDropdown(addEmployee.location, "London Office");
	}

	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		click(addEmployee.saveBtn);
	}

	// hardcoded step
	@Then("validate that employee is added successfully")
	public void validate_that_employee_is_added_successfully() {

		waitForVisibility(personalDetails.personalDetailsForm);

		String expected = "Lionel Messi";
		String actual = personalDetails.employeeName.getText();

		// Please make sure you import the Assert class under org.junit package
		Assert.assertEquals("The name DOES NOT match!", expected, actual);
	}

	// parametrized step
	@Then("validate that employee {string} is added successfully")
	public void validate_that_employee_is_added_successfully(String expectedText) {
		waitForVisibility(personalDetails.personalDetailsForm);
		String actualText = personalDetails.employeeName.getText();
		Assert.assertEquals("The name DOES NOT match!", expectedText, actualText);
	}

	@When("user deletes employee id")
	public void user_deletes_employee_id() {
		wait(1);
		addEmployee.employeeId.clear();
		wait(1);
	}

	@When("user clicks on Create Login Details")
	public void user_clicks_on_create_login_details() {
		jsClick(addEmployee.checkBoxLoginDetails);
	}

	@When("user provides credentials")
	public void user_provides_credentials() {
		sendText(addEmployee.username, "Leo123");
		sendText(addEmployee.password, "Argentina@123");
		sendText(addEmployee.confirmPassword, "Argentina@123");
		wait(1);
	}

}
