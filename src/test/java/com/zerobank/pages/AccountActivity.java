package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends BasePage{

    @FindBy(id = "aa_accountId")
    public WebElement accountDropdown;

    @FindBy(partialLinkText = "Show Transactions")
    public WebElement showTransictions;

    @FindBy(partialLinkText = "Find Transactions")
    public WebElement findTransictions;

    @FindBy(id = "aa_description")
    public WebElement descriptionInput;

    @FindBy(id = "aa_fromDate")
    public WebElement dateFrom;

    @FindBy(id = "aa_toDate")
    public WebElement dateTo;

    @FindBy(id = "aa_fromAmount")
    public WebElement amountFrom;

    @FindBy(id = "aa_toAmount")
    public WebElement amountTo;

    @FindBy(id = "aa_type")
    public WebElement type;

    @FindBy(css = "[class='btn btn-primary']")
    public WebElement search;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover']/tbody)[1]/tr")
    public WebElement showTransictionsTable;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover']/tbody)[2]/tr")
    public String findTransictionsTable;



    public String dropdown(){
        Select select=new Select(accountDropdown);
        List<WebElement> options = select.getOptions();
        String  option=select.getFirstSelectedOption().getText();
        return option;
    }

    public List<WebElement> transactionList(){
        List<WebElement> translist=Driver.get().findElements(By.xpath("(//table[@class='table table-condensed table-hover']/tbody)[2]/tr"));
        return translist;
    }

    public List<WebElement> detailedList(String detail){
        List<WebElement> datails=new ArrayList<>();

        if(detail.equals("Date")){
            datails.addAll(Driver.get().findElements(By.xpath("(//tbody)[2]//td[1]")));
        }else if(detail.equals("Description")){
            datails.addAll(Driver.get().findElements(By.xpath("(//tbody)[2]//td[2]")));
        }else if(detail.equals("Deposit")){
            datails.addAll(Driver.get().findElements(By.xpath("(//tbody)[2]//td[3]")));
        }else if(detail.equals("Withdrawal")){
            datails.addAll(Driver.get().findElements(By.xpath("(//tbody)[2]//td[4]")));
        }
        return datails;
    }

}
