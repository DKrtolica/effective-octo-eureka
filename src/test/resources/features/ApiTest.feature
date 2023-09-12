Feature: Feature to API functionality

  Scenario: Check user can be retrieved by username
    Given I am authenticated as api user with "dkrtolica" and "Admin123!"
    When I submit request to get user "dkrtolica"
    Then status code is  200

  Scenario: Check new user can be created
    Given I am authenticated with "Wednesday" and 7


    #https://petstore.swagger.io/#/pet/findPetsByStatus