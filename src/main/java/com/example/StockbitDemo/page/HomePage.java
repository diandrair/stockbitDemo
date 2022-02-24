package com.example.StockbitDemo.page;

import com.example.StockbitDemo.AbstractBasePage;
import com.example.StockbitDemo.util.BrowserActions;
import com.example.StockbitDemo.util.DataUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends AbstractBasePage {

    @Autowired
    BrowserActions browserActions;

    String url = DataUtils.getDataFromExcel("Config", "BaseUrl");

    @FindBy(id = "landing-logo")
    private WebElement landingLogo;

    @FindBy(xpath = "//div[@class='topmenu']//a[@href='https://stockbit.com/#/register'][contains(text(), 'Sign Up')]")
    private WebElement signUpBtn;

    @FindBy(xpath = "//div[@class='menuchild-parent desktop']//div//a[@class='login-ldn'][normalize-space()='Log In']")
    private WebElement loginBtn;

    public void goTo(){
        this.driver.get(url);
    }

    public void goToRegisterPage(){
        browserActions.clickElement(signUpBtn);
    }

    public void goToLoginPage(){
        browserActions.clickElement(loginBtn);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d)-> this.landingLogo.isDisplayed());
    }
}
