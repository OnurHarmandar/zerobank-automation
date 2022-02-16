package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityDef {
    AccountActivity accountActivity=new AccountActivity();
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        String username= ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");

        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
        Driver.get().navigate().to("http://zero.webappsecurity.com/bank/account-summary.html");

    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String option) {
        Driver.get().findElement(By.partialLinkText(option)).click();
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String page) {
    Assert.assertTrue(Driver.get().findElement(By.partialLinkText(page)).isDisplayed());
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String option) {

    BrowserUtils.waitFor(2);
    String actualSelectedDropDown=accountActivity.dropdown();
    System.out.println("actualSelectedDropDown = " + actualSelectedDropDown);
    System.out.println("option = " + option);
    Assert.assertEquals(option,actualSelectedDropDown);
    }


    @Then("In the {string} drop down default option should be {string}")
    public void inTheDropDownDefaultOptionShouldBe(String dropDown, String selected) {
        String actuallSelected=accountActivity.dropdown();
        System.out.println("actuallSelected = " + actuallSelected);
        System.out.println("selected = " + selected);
        Assert.assertEquals(selected,actuallSelected);
    }

    @Then("{string} drop down should have the following options:")
    public void dropDownShouldHaveTheFollowingOptions(String arg0) {
        Select select=new Select(accountActivity.accountDropdown);
        System.out.println("select.getAllSelectedOptions() = " + select.getAllSelectedOptions());
    }


}
