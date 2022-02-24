package com.example.StockbitDemo.page;

import com.example.StockbitDemo.AbstractBasePage;
import com.example.StockbitDemo.util.BrowserActions;
import com.example.StockbitDemo.util.DataUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginFormPage extends AbstractBasePage {

    @Autowired
    private BrowserActions browserActions;

    String username = DataUtils.getDataFromExcel("Config", "Username");
    String password = DataUtils.getDataFromExcel("Config", "Password");

    @FindBy(id = "form-login")
    private WebElement formLogin;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwodInput;

    @FindBy(id = "loginbutton")
    private WebElement loginBtn;

    public void usingEmail (){
        browserActions.sendKeysToElement(usernameInput, username);
        browserActions.sendKeysToElement(passwodInput, password);

    }

    @Override
    public boolean isAt() {
        return this.wait.until((d)-> this.formLogin.isDisplayed() );
    }
}