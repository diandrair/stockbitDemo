package com.example.StockbitDemo.page;

import com.example.StockbitDemo.AbstractBasePage;
import com.example.StockbitDemo.util.BrowserActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterPage extends AbstractBasePage {

    @Autowired
    BrowserActions browserActions;

    @FindBy(id = "form-register")
    private WebElement formRegister;

    @FindBy(xpath = "//input[@value='Register with Google']")
    private WebElement registWithGoogleBtn;

    @FindBy(xpath = "//a[normalize-space()='Register with Facebook']")
    private WebElement registWithFacebookBtn;

    @FindBy(xpath = "//a[normalize-space()='Register with Email']")
    private WebElement registWithEmailBtn;

    public void googleSignUp(){
        browserActions.clickElement(registWithGoogleBtn);
    }

    public void facebookSignUp(){
        browserActions.clickElement(registWithFacebookBtn);
    }

    public void emailSignUp(){
        browserActions.clickElement(registWithEmailBtn);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d)-> this.formRegister.isDisplayed() );
    }
}
