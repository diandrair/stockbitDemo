package com.example.StockbitDemo.StepDefinitions;

import com.example.StockbitDemo.page.HomePage;
import com.example.StockbitDemo.page.RegisterPage;
import com.example.StockbitDemo.page.SignUpFormPage;
import com.example.StockbitDemo.util.ExcelReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class SignUpStep {

    @Autowired
    HomePage homePage;

    @Autowired
    RegisterPage registerPage;

    @Autowired
    SignUpFormPage signUpFormPage;

    @Given("Go to home page")
    public void goToHomePage() {
        homePage.goTo();
        Assert.assertTrue(homePage.isAt());
    }

    @When("I click Sign Up button and select sign up using google")
    public void iClickSignUpButtonAndSelectSignUpUsingGoogle() {
        registerPage.googleSignUp();
    }

    @When("I click Sign Up button and select sign up using facebook")
    public void iClickSignUpButtonAndSelectSignUpUsingFacebook() {
        registerPage.facebookSignUp();
    }

    @When("I click Sign Up button and select sign up using email")
    public void iClickSignUpButtonAndSelectSignUpUsingEmail() {
        registerPage.emailSignUp();
    }


    @And("I am on google landing page and select {string}")
    public void iAmOnGoogleLandingPageAndSelect(String account) {
//        assert if we can see google pop up page
//        click account yang memiliki email "account"
    }

    @And("I am on facebook landing page and login using facebook {string} and {string}")
    public void iAmOnFacebookLandingPageAndLoginUsingFacebookAnd(String username, String password) {
//        assert if we can see facebook pop up page
//        login facebook dengan 'username' dan 'password'
    }

    @And("I fill out google registration form")
    public void iFillOutGoogleRegistrationForm() {
        signUpFormPage.google();
    }
    @And("I fill out facebook registration form")
    public void iFillOutFacebookRegistrationForm() {
        signUpFormPage.facebook();
    }

    @And("I fill out email registration form using data given sheetname {string} and rownumber {int}")
    public void iFillOutEmailRegistration(String sheetName, int rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData( sheetName);

        String nama = testData.get(rowNumber).get("Full Name");
        String email = testData.get(rowNumber).get("Email Address");
        String username = testData.get(rowNumber).get("Username");
        String pass = testData.get(rowNumber).get("Pass");

        signUpFormPage.email(nama,pass, email, username);

    }

    @Then("I can see dashboard page then logout")
    public void iCanSeeDashboardPageThenLogout() {
//        assert if we successfully signed up then log out
    }


    @And("I am on Sign Up page")
    public void iAmOnSignUpPage() {
//        assert if we can see sign up form
    }



}