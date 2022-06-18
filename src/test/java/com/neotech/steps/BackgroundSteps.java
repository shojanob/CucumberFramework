package com.neotech.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundSteps {

	@Given("Precondition1")
	public void precondition1() {
		System.out.println("Running precondition1");
	}
	@Given("Precondition2")
	public void precondition2() {
		System.out.println("Running precondition2");
	}
	@When("Test number nr1")
	public void test_number_nr1() {
		System.out.println("Running test1");
	}
	@When("Test number nr2")
	public void test_number_nr2() {
		System.out.println("Running test2");
		}
	@When("Test number nr3")
	public void test_number_nr3() {
		System.out.println("Running test3");
	}
	@Then("Validation Nr1")
	public void validation_nr1() {
		System.out.println("Running validation1");
	}
	@Then("Validation Nr2")
	public void validation_nr2() {
		System.out.println("Running validation2");
	}

	
	@When("Test number nr4")
	public void test_number_nr4() {
		System.out.println("Running test4");
	}
	@When("Test number nr5")
	public void test_number_nr5() {
		System.out.println("Running test5");
	}
	@When("Test number nr6")
	public void test_number_nr6() {
		System.out.println("Running test6");
	}
	@Then("Validation Nr3")
	public void validation_nr3() {
		System.out.println("Running validation3");
	}
	@Then("Validation Nr4")
	public void validation_nr4() {
		System.out.println("Running validation4");
	}
	
	
}
