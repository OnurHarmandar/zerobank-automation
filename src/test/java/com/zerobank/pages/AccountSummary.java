package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AccountSummary extends BasePage{
    @FindBy(css = ".board-header")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "//table")
    public List<WebElement> tables;

    public List<String> accountTable(String accountType){
        List<String> textOfTable=new ArrayList<>();
        if(accountType.equals("Cash Accounts")){
            textOfTable.add(tables.get(0).getText());
        }else if (accountType.equals("Investment Accounts")){
            textOfTable.add(tables.get(1).getText());
        }else  if (accountType.equals("Credit Accounts")){
            textOfTable.add(tables.get(2).getText());
        }else if (accountType.equals("Loan Accounts")){
            textOfTable.add(tables.get(3).getText());
        }
        return textOfTable;
    }




}

