package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryDef {

    AccountSummary accountSummary=new AccountSummary();
    @Then("{string} has the title {string}")
    public void has_the_title(String tab, String expectedTitle) {
        String actuallTitle= Driver.get().getTitle();
        System.out.println("actuallTitle = " + actuallTitle);
        Assert.assertEquals(expectedTitle,actuallTitle);
    }

    @Then("the page should have following account types")
    public void the_page_should_have_following_account_types(List<String> accountType) {
        List<String> actuallAccountTypes= BrowserUtils.getElementsText(accountSummary.accountTypes);
        System.out.println(actuallAccountTypes);
        System.out.println(accountType);
        Assert.assertEquals(accountType,actuallAccountTypes);

    }

    @Then("{string} should have {string} {string} {string}")
    public void should_have(String accountType, String column1, String column2, String column3) {
        List<String> tableList=accountSummary.accountTable(accountType);
        System.out.println(tableList.get(0).toString());
        Assert.assertTrue(tableList.get(0).contains(column1)&&tableList.get(0).contains(column2)&&tableList.get(0).contains(column3));
    }

    @Then("{string} should have {string} {string}")
    public void should_have(String accountType, String row1, String row2) {
       List<String> tableList=accountSummary.accountTable(accountType);
        System.out.println(tableList.get(0).toString());
       Assert.assertTrue(tableList.get(0).contains(row1)&&tableList.get(0).contains(row2));
    }



}
