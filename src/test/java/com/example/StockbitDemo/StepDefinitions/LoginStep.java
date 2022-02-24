package com.example.StockbitDemo.StepDefinitions;

import com.example.StockbitDemo.page.HomePage;
import com.example.StockbitDemo.page.LoginFormPage;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginStep {

    @Autowired
    private LoginFormPage loginFormPage;

    @Autowired
    private HomePage homePage;

    @When("I click Login button and sign up using email")
    public void iClickLoginButtonAndSignUpUsingEmail() {
        homePage.goToLoginPage();
        loginFormPage.usingEmail();
    }

    @When("I click Login button and sign up using account google-email")
    public void iClickLoginButtonAndSignUpUsingAccountGoogleEmail() {
    }

    @When("I click Login button and sign up using account facebook")
    public void iClickLoginButtonAndSignUpUsingAccountFacebook() {
    }
}
