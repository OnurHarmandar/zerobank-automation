package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "signin_button")
    public WebElement signInButton;

    @FindBy(id = "user_login")
    public WebElement username;

    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(name = "submit")
    public WebElement signIn;

    @FindBy(css = "[class='alert alert-error']")
    public WebElement message;

    @FindBy(xpath = "//h3")
    public WebElement header;

    @FindBy(id = "user_email")
    public WebElement emailInput;

    @FindBy(css = "[class='btn btn-primary']")
    public WebElement sendEmail;

    public void login(String usernameStr,String passwordStr){
        username.sendKeys(usernameStr);
        password.sendKeys(passwordStr);
        signIn.click();
    }

}
