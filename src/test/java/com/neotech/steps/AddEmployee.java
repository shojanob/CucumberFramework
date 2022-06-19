package com.neotech.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.neotech.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
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

	// Extra methods from Scenario Outline
	@When("user enters employee {string}, {string} and {string}")
	public void user_enters_employee_and(String first_name, String middle_name, String last_name) {
		sendText(addEmployee.firstName, first_name);
		sendText(addEmployee.middleName, middle_name);
		sendText(addEmployee.lastName, last_name);
	}

	@When("user selects a location {string}")
	public void user_selects_a_location(String location) {
		selectDropdown(addEmployee.location, location);
	}

	@Then("validate that {string} and {string} is added successfully")
	public void validate_that_and_is_added_successfully(String firstN, String lastN) {
		waitForVisibility(personalDetails.personalDetailsForm);

		String expectedName = firstN + "-" + lastN;
		String actualName = personalDetails.employeeName.getText();

		Assert.assertEquals("The name DOES NOT match!", expectedName, actualName);
	}

	// Extra methods from DataTable
	@When("user enters employee details and clicks on save and validates it is added")
	public void user_enters_employee_details_and_clicks_on_save_and_validates_it_is_added(DataTable table) {
		System.out.println(table);

		// asMaps() method converts DataTable into a List of Maps
		List<Map<String, String>> empList = table.asMaps();
		// System.out.println(empList);

		for (Map<String, String> employee : empList) {
			System.out.println(employee);

			String fName = employee.get("FirstName");
			String mName = employee.get("MiddleName");
			String lName = employee.get("LastName");

			sendText(addEmployee.firstName, fName);
			sendText(addEmployee.middleName, mName);
			sendText(addEmployee.lastName, lName);

			selectDropdown(addEmployee.location, "London Office");

			wait(1);

			click(addEmployee.saveBtn);

			waitForVisibility(personalDetails.personalDetailsForm);

			// Validation
			String expectedTxt = fName + " " + lName;
			String actualTxt = personalDetails.employeeName.getText();

			Assert.assertEquals("The name DOES NOT match!", expectedTxt, actualTxt);

			// Before next iteration
			// We need to go to Add Employee page again
			wait(1);
			click(dashboard.addEmployeeLink);
		}
	}

}
