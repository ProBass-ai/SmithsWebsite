@web
Feature: Profile Analysis Feature
  Background:
    Given the user is on the home page

  Scenario Outline: Validate that a user may search for a user
    When a user seaches for "<user>"
    Then the repo count must be "<repo_count>"
    And the follower count must be "<follower_count>"
    And the the following count must be "<following_count>"
    And the the gists count must be "<gists_count>"

    Examples:
      | user  | repo_count | follower_count | following_count | gists_count |
      | Smith | 229        | 119            | 192             | 95          |


  Scenario Outline: Validate a user may see correct employment details
    When a user seaches for "<user>"
    Then the company tag is "<company_tag>"
    And the location is "<location>"
    And the link is "<link>"

    Examples:
      | user  | company_tag | location          | link                        |
      | Smith | @elastic    | South Amana, Iowa | https://http//nlsmith.com/  |


  Scenario Outline: Validate that a user has a following
    When a user seaches for "<user>"
    Then "<follower>" is in the follower list

    Examples:
      | user  | follower       |
      | Smith | Nevilleburnell |
