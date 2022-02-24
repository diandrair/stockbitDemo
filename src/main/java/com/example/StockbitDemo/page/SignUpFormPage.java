package com.example.StockbitDemo.page;

import com.example.StockbitDemo.AbstractBasePage;
import com.example.StockbitDemo.util.BrowserActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignUpFormPage extends AbstractBasePage {

//    landing page choose google account
    @FindBy(id = "headingText")
    private WebElement chooseAnAccountHeadText;



    @FindBy(id = "input-1")
    private WebElement nameInput;

    @FindBy(id = "input-2")
    private WebElement emailInput;

    @FindBy(id = "input-3")
    private WebElement usernameInput;

    @FindBy(id = "input-4")
    private WebElement passwordInput;

    @FindBy(id = "input-5")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registerBtn;

    @FindBy(id = "form-register")
    private WebElement formRegister;

    @Autowired
    private BrowserActions browserActions;

    public void google(){
    }

    public void facebook(){
    }

    public void email(String name, String pass, String email, String uname){
        browserActions.sendKeysToElement(nameInput, name);
        browserActions.sendKeysToElement(emailInput,email);
        browserActions.sendKeysToElement(usernameInput,uname);
        browserActions.sendKeysToElement(passwordInput,pass);
        browserActions.sendKeysToElement(confirmPasswordInput,pass);
        browserActions.clickElement(registerBtn);
    }

    @Override
    public boolean isAt() {
       return this.wait.until((d)-> this.formRegister.isDisplayed());
    }
}
