package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindTransictionDef {

    AccountActivity accountActivity=new AccountActivity();
    @When("the user navigate to {string} tab")
    public void the_user_navigate_to_tab(String tab) {
        accountActivity.navigateTo(tab);
        BrowserUtils.waitFor(1);
    }

    @Given("the user accesses the {string} tab")
    public void the_user_accesses_the_cash_tab(String module) {
        accountActivity.navigateTo(module);
        BrowserUtils.waitFor(1);
    }


    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String dateFrom, String dateTo) {
        BrowserUtils.waitFor(1);
        accountActivity.dateFrom.clear();
        accountActivity.dateFrom.sendKeys(dateFrom);
        accountActivity.dateTo.clear();
        accountActivity.dateTo.sendKeys(dateTo);

    }

    @When("clicks search")
    public void clicks_search() {
       accountActivity.search.click();
       BrowserUtils.waitFor(3);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String startingDate, String endingDate) throws ParseException {
        List<WebElement> dates=accountActivity.detailedList("Date");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date actualFirstTransaction=sdf.parse(dates.get(dates.size()-1).getText());
        Date actualLastTransaction=sdf.parse(dates.get(0).getText());
        Date expectedFirstTransaction=sdf.parse(startingDate);
        Date expectedLastTransaction=sdf.parse(endingDate);
        int firstDatesCompare=expectedFirstTransaction.compareTo(actualFirstTransaction);
        int lastDatesCompare=expectedLastTransaction.compareTo(actualLastTransaction);

        System.out.println("firstDatesCompare = " + firstDatesCompare);
        System.out.println("lastDatesCompare = " + lastDatesCompare);
        Assert.assertTrue(firstDatesCompare<=0&&lastDatesCompare>=0);

    }


    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<String> list=new ArrayList<>();
        for (WebElement element:accountActivity.detailedList("Date")){
            list.add(element.getText());
        }
       boolean isSorted= BrowserUtils.isReverseSorted(list);
        System.out.println("isSorted = " + isSorted);
        Assert.assertTrue(isSorted);
    }


    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        Assert.assertFalse(accountActivity.transactionList().contains(string));

    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        BrowserUtils.waitFor(1);
        accountActivity.descriptionInput.sendKeys(Keys.COMMAND,"a",Keys.BACK_SPACE);
        accountActivity.descriptionInput.sendKeys(description);
        BrowserUtils.waitFor(2);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {

        for(WebElement element:accountActivity.transactionList()) {
            if(description.equals("ONLINE")){
                System.out.println("element.getText() = " + element.getText());
                Assert.assertTrue(element.getText().contains(description));
                Assert.assertFalse(element.getText().contains("OFFICE"));
            }else if (description.equals("OFFICE")){
                Assert.assertTrue(element.getText().contains(description));
                Assert.assertFalse(element.getText().contains("ONLINE"));
            }
        }
    }
    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String nonDescription) {
        for(WebElement element:accountActivity.transactionList()) {
            if(nonDescription.equals("ONLINE")){
                System.out.println("element.getText() = " + element.getText());
                Assert.assertFalse(element.getText().contains(nonDescription));
            }else if (nonDescription.equals("OFFICE")){
                Assert.assertFalse(element.getText().contains(nonDescription));
            }
        }
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String detail) {
        List<WebElement> eachRow=accountActivity.detailedList(detail);
        List<WebElement> result1=new ArrayList<>();
        for (WebElement element:eachRow){
            if(!element.getText().equals("")){
                result1.add(element);
            }
        }
        if (result1.size()>=1){
            Assert.assertTrue(result1.size()>=1);
        }
        System.out.println("result1.size() = " + result1.size());

    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        Select select=new Select(accountActivity.type);
        select.selectByVisibleText(type);
        BrowserUtils.waitFor(2);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String detail) {
        List<WebElement> eachRow=accountActivity.detailedList(detail);
        List<WebElement> result2=new ArrayList<>();
        for (WebElement element:eachRow){
            if(!element.getText().equals("")){
                result2.add(element);
            }
        }
        if (result2.size()<1){
            Assert.assertTrue(result2.size()==0);
        }
        System.out.println("result2.size() = " + result2.size());
    }






}
