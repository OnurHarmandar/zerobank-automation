package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBills;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PayBillsDef {
    PayBills payBills=new PayBills();


    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {
        payBills.payeeNameInput.sendKeys(dataTable.get("Payee Name"));
        payBills.payeeAdressInput.sendKeys(dataTable.get("Payee Address"));
        payBills.accountInput.sendKeys(dataTable.get("Account"));
        payBills.payeeDetails.sendKeys(dataTable.get("Payee details"));
        BrowserUtils.waitFor(1);
        payBills.add.click();
        BrowserUtils.waitFor(2);
    }
    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String message) {
        String expectedMessage=message;
        String actuallMessage=payBills.massage.getText();

        System.out.println("actuallMessage = " + actuallMessage);
        Assert.assertTrue(payBills.massage.isDisplayed());
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencies) {
        Select select=new Select(payBills.currencySelect);
        List<WebElement> currenciesElements=select.getOptions();
        List<String> actuallCurrencies=new ArrayList<>();
        for(WebElement element:currenciesElements){
            actuallCurrencies.add(element.getText());
            System.out.println(element.getText());
        }
        actuallCurrencies.remove(0);
        System.out.println("===========");
        System.out.println(currencies);
        Assert.assertTrue(actuallCurrencies.containsAll(currencies));
        //Assert.assertEquals(currencies,actuallCurrencies);
    }


    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
       payBills.amount.sendKeys("100");
        payBills.dollarRaadioBtn.click();
        payBills.calculateCost.click();
        BrowserUtils.waitFor(2);
    }
    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert= Driver.get().switchTo().alert();
        BrowserUtils.waitFor(1);
        System.out.println("alert.getText() = " + alert.getText());
        Assert.assertFalse(alert.getText().equals(null));
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        Select select=new Select(payBills.currencySelect);
        select.selectByIndex(3);
        payBills.dollarRaadioBtn.click();
        payBills.calculateCost.click();
        BrowserUtils.waitFor(2);
    }

    @Given("the user selects {string} for {string}")
    public void the_user_selects_for(String selected, String feature) {
        Select select=payBills.select(feature);
        select.selectByVisibleText(selected);
    }

    @And("the user adds {string} to {string} inputbox")
    public void theUserAddsToInputbox(String information, String type) {
        payBills.addSomeThing(type).sendKeys(information);
    }


    @Then("{string} alert should displayed on {string}")
    public void alert_should_displayed_on(String message, String type) {
        String alert=payBills.addSomeThing(type).getAttribute("validationMessage");
        System.out.println("alert = " + alert);
        Assert.assertTrue(payBills.addAmount.getAttribute("validationMessage").isBlank());
        Assert.assertTrue(alert.equals(message));
    }


    @Then("message {string} should NOT be displayed")
    public void messageShouldNOTBeDisplayed(String message) {
        String expectedMessage=message;
        String actuallMessage=payBills.massage.getText();

        System.out.println("actuallMessage = " + actuallMessage);
        Assert.assertFalse(payBills.massage.isDisplayed());
    }

    @Then("the user adds {string} to {string} inputbox and cuts the value")
    public void theUserAddsToInputboxAndCutsTheValue(String information, String type) {
        payBills.addSomeThing(type).sendKeys(information);
        BrowserUtils.waitFor(1);
        payBills.addAmount.sendKeys(Keys.COMMAND,"a");
        BrowserUtils.waitFor(1);
        payBills.addAmount.sendKeys(Keys.COMMAND,"x");
        BrowserUtils.waitFor(1);
    }

    @And("the user adds the firs input of amount to Date inputbox by cut+paste fromkeyboard")
    public void theUserAddsTheFirsInputOfAmountToDateInputboxByCutPasteFromkeyboard() {
        payBills.dateInput.sendKeys(Keys.COMMAND,"v");
        BrowserUtils.waitFor(1);
        System.out.println("date:"+payBills.dateInput.getAttribute("value"));
    }
}
