@signUp
Feature: Sign Up
  @signUpGoogle
  Scenario Outline: Sign up as new user using google account
    Given Go to home page
    When I click Sign Up button and select sign up using google
    And I am on google landing page and select "<account>"
    And I fill out google registration form
    Then I can see dashboard page then logout
    Examples:
      | account               |
      |     xxxx@gmail.com    |

  @signUpFacebook
  Scenario Outline: Sign up as new user using facebook account
    Given Go to home page
    When I click Sign Up button and select sign up using facebook
    And I am on facebook landing page and login using facebook "<username>" and "<password>"
    And I fill out facebook registration form
    Then I can see dashboard page then logout
    Examples:
      | username | password |
      | diandXXX | 123^$@@  |

  @signUpEmail
  Scenario Outline: Sign up as new user using email account
    Given Go to home page
    When I click Sign Up button and select sign up using email
    And I am on Sign Up page
    And I fill out email registration form using data given sheetname "<SheetName>" and rownumber <RowNumber>
    Then I can see dashboard page then logout
    Examples:
      | SheetName | RowNumber |
      | Sign Up   | 0         |
      | Sign Up   | 1         |
      | Sign Up   | 2         |



