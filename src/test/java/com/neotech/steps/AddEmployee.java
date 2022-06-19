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

	@When("user enters employee first name and last name")
	public void user_enters_employee_first_name_and_last_name() {
		sendText(addEmployee.firstName, "Lionel");
		sendText(addEmployee.lastName, "Messi");
	}

	@When("user selects a location")
	public void user_selects_a_location() {
		selectDropdown(addEmployee.location, "London Office");
	}

	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		click(addEmployee.saveBtn);
	}

	@Then("validate that employee is added successfully")
	public void validate_that_employee_is_added_successfully() {

		waitForVisibility(personalDetails.personalDetailsForm);

		String expected = "Lionel Messi";
		String actual = personalDetails.employeeName.getText();

		// Please make sure you import the Assert class under org.junit package
		Assert.assertEquals("The name DOES NOT match!", expected, actual);
	}

}
