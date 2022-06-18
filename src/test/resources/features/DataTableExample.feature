Feature: Writing Scenarios with DataTable

	@DataTable
  Scenario: Add employee with datatable
    When I login to the HRMS
    And I want to add employees
      | FirstName | MiddleName | LastName |
      | Kamer     | Can        | Akarsu   |
      | Brian     |            | Smith    |
      | Tuba      |            | Kutlu    |
    Then I validate employee added
