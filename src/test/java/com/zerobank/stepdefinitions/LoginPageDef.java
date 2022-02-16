package com.zerobank.stepdefinitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPageDef {
    LoginPage loginPage=new LoginPage();

    @When("user enters {string} as username")
    public void user_enters_as_username(String userName) {
        loginPage.username.sendKeys(userName);
    }

    @When("user enters {string} as password")
    public void user_enters_as_password(String Password) {
        loginPage.password.sendKeys(Password);
    }


    @Then("user clicks on Sign in button")
    public void user_clicks_on_Sign_in_button() {
        loginPage.signIn.click();
        BrowserUtils.waitFor(1);
    }

    @Then("verify that user successfully loged in")
    public void verify_that_user_successfully_loged_in() {
        Driver.get().navigate().back();
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().getTitle().contains("Personal Banking"));
    }

    @When("user clicks on Enter button on keyboard")
    public void user_clicks_on_Enter_button_on_keyboard() {
        loginPage.signIn.sendKeys(Keys.ENTER);
        BrowserUtils.waitFor(1);
        Driver.get().navigate().back();
        BrowserUtils.waitFor(1);
    }
    @Given("user enters invalid {string} as username")
    public void user_enters_invalid_as_username(String userName) {
       loginPage.username.sendKeys(userName);
    }

    @Given("user enters invalid {string} as password")
    public void user_enters_invalid_as_password(String Password) {
        loginPage.password.sendKeys(Password);
        BrowserUtils.waitFor(2);
    }


    @Then("{string} message is displayed")
    public void message_is_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage,loginPage.message.getText());
    }
    @Then("header change as {string}")
    public void header_change_as(String expectedHeader) {
        Assert.assertEquals(expectedHeader,loginPage.header.getText());
    }

    @Then("{string} message dissappears")
    public void message_dissappears(String message) {

            Assert.assertTrue(Driver.get().findElement(By.xpath("//p")).getText().contains(message));
    }

    @Then("user enters a valid {string}")
    public void user_enters_a_valid(String email) {
        BrowserUtils.waitFor(2);
        System.out.println("email = " + email);
        loginPage.emailInput.sendKeys(email);
        BrowserUtils.waitFor(2);
    }
    @Then("user clicks on Send Password button")
    public void user_clicks_on_Send_Password_button() {
        loginPage.sendEmail.click();
    }

    @Then("{string} {string} message dissappears")
    public void message_dissappears(String message, String email) {
        System.out.println(Driver.get().findElement(By.xpath("//div[@class='offset3 span6']")).getText());
        Assert.assertTrue(Driver.get().findElement(By.xpath("//div[@class='offset3 span6']")).getText().contains(message+" "+email));
    }

}
