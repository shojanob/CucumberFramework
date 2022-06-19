#Author: Neotech Academy
Feature: Add Employee Feature
  I want to test the Add Employee Functionality

  Background: 
    Given user is logged in with valid credentials
    And user navigates to AddEmployee page

  @AddEmployee
  Scenario: Add Employee with first and last name
    When user enters employee first name and last name
    And user selects a location
    And user clicks on save button
    Then validate that employee is added successfully

  @task
  Scenario: Add Employee with parametrized first and last name
    When user enters employee first name "Cristiano" and last name "Ronaldo"
    And user selects a location
    And user clicks on save button
    Then validate that employee "Cristiano Ronaldo" is added successfully

  @second
  Scenario: Add Employee without employee id
    When user enters employee first name and last name
    And user deletes employee id
    And user selects a location
    And user clicks on save button
    Then validate that employee is added successfully

  @third
  Scenario: Add Employee and create login Credentials
    When user enters employee first name and last name
    And user selects a location
    And user clicks on Create Login Details
    And user provides credentials
    And user clicks on save button
    Then validate that employee is added successfully

  #To perform DDT using Scenario Outline and Examples keyword
  @scenarioOutline
  Scenario Outline: Adding multiple employees with scenario outline
    When user enters employee "<FirstName>", "<MiddleName>" and "<LastName>"
    And user selects a location "<Location>"
    And user clicks on save button
    Then validate that "<FirstName>" and "<LastName>" is added successfully

    Examples: 
      | FirstName | MiddleName | LastName | Location                         |
      | Joe       | R          | Biden    | London Office                    |
      | Donald    | J          | Trump    | Chinese Development Center       |
      | Barack    | H          | Obama    | South African Development Center |
