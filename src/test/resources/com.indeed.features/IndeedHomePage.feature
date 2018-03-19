Feature: Indeed Job Search

  Scenario: Search a job by City
    Given I navigate the website indeed
    And I enter a job in What search box and I enter a City in Where Box and Search
    When I verify the title has search arguments
   