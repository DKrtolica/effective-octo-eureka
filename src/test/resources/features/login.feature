Feature: Feature to test login functionality in UI

	Background:
		Given user is on login page

  Scenario: Check login is successful with valid username & password
    Given user enters correct username and password on the login page
    When user clicks on login button
    Then user should land on the home page



    #https://www.saucedemo.com/
  #https://github.com/jefly/AutomationSelenium

























#  Scenario Outline: Check login is successful with valid username & password
#    Given user enters correct credentials on the login page
#
##    When user clicks on login button
##    Then user should land on the home page
#    Examples:
#      | username | password |
#      | value1  | value2  |
#      | value5  | value6  |