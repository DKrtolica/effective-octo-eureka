Feature: Feature to test login functionality in UI

	Background:
		Given user is on Request a Demo page

  Scenario: User can fill out the form with random data and submit it
    Given User enters all the required random data on request demo page
    When User clicks Request a Demo Today button
    Then User should remain on the Request a Demo page


  Scenario: User can right click on an element
    When User can right click on an element on the page
    Then User should remain on the Request a Demo page



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