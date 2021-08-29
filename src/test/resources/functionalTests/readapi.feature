@All
Feature: Read API Data
 
  @ReadAPI
  Scenario: Read API using Rest assured
    Given get response from server
    Then check status code of response
    Then check status line of response
    Then check headers of response