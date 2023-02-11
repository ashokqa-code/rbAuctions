Feature: Search vehicles on home page

  @rbAuctions
  Scenario: Search for given vehicle and validate results returned
    Given User navigated to home page
    Then Search for 'Ford F-150' using search bar
    Then Validate the results count showed on the home page
    Then Validate first result on the page has the word 'Ford F-150' in it
    And User applies the year filter to be from '2010' to current year
    Then Validate results count returned is different after filter applied