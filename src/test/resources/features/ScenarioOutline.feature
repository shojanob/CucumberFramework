Feature: Writing Scenario Outline Example

  @Outline
  Scenario Outline: 
    When Login with "<username>" and "<password>"
    And Click on the login button
    Then I validate Welcome "<username>" is displayed
    And We want to say Bye "<fullname>"

    Examples: 
      | username | password | fullname            |
      | Sherzod  | s1234    | SherzodTokhtakhunov |
      | Emre     | emre123  | EmreYucel           |
      | Brian    | brian123 |                     |
