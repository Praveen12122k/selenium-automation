Feature: Login functionality
  Scenario Outline: Login with different credentials
    Given User is on login Home page
    When User enters username "<username>" and password "<password>"
    And Click on login button
    Then User should see login result "<result>"
    Examples:
      | username      | password             | result   |
      | tomsmith      | SuperSecretPassword! | secure   |
      | wrongusername | wrongpassword        | invalid! |
      |               |                      | invalid! |
