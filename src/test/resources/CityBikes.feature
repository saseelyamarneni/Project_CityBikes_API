Feature: City bikes API automation tests using BDD

  Background: Connecting to City bikes API endpoint
    Given I call city bikes API networks endpoint "http://api.citybik.es/v2"
    Then I have a valid response from the API

  Scenario: As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude
    Given I have a valid response from the API
    Then Verify that city "Frankfurt" is in Germany with country code "DE"
    And I receive it's corresponding latitude and longitude values

    Scenario Outline:As a user I want to verify that a city is having City bikes and return their corresponded latitude and longitude
      Given I have a valid response from the API
      Then Verify that city "<City>" is in a country with country code "<Country Code>"
      And I receive it's corresponding latitude and longitude values
      Examples:
      |City      |Country Code|
      |Copenhagen|DK|
      |Venezia   |IT|
      |Torino    |IT|

      Scenario: As a user I want to verify that a particular network is having a open license for the city bikes
        Given I have a valid response from the API
        Then Verify that the "villo" city bikes network is having a valid "Open Licence"