@login
Feature: login
  @loginEmail
  Scenario: : login using email
    Given Go to home page
    When I click Login button and sign up using email
    Then I can see dashboard page then logout

  @loginGoogle
  Scenario: : login using google email
    Given Go to home page
    When I click Login button and sign up using account google-email
    Then I can see dashboard page then logout

  @loginFacebook
  Scenario: : login using facebook
    Given Go to home page
    When I click Login button and sign up using account facebook
    Then I can see dashboard page then logout