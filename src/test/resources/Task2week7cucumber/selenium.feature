@homework
Feature: Homework
  Scenario Outline:  dynamic url
    Given user goes to the "<page_url>"
    Then user waits for 5 seconds
    And verifies that the page title contains the word "<title>"
    And closes the page
    Examples:
      |page_url|  title|
      |https://www.google.com | Google |
      |https://www.amazon.com | Amazon |
      |https://www.youtube.com | YouTube  |