package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PayBills extends BasePage{

    @FindBy(partialLinkText = "Pay Saved Payee")
    public WebElement paySavedPayee;
    @FindBy(id = "sp_payee")
    public WebElement selectPayee;
    @FindBy(id = "sp_account")
    public WebElement selectAccount;
    @FindBy(id = "sp_amount")
    public WebElement addAmount;
    @FindBy(id = "sp_date")
    public WebElement dateInput;
    @FindBy(id = "sp_description")
    public WebElement descriptionInput;

    @FindBy(partialLinkText = "Add New Payee")
    public WebElement addNewPayee;
    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameInput;
    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAdressInput;
    @FindBy(id = "np_new_payee_account")
    public WebElement accountInput;
    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails;
    @FindBy(id = "add_new_payee")
    public WebElement add;
    @FindBy(id = "alert_content")
    public WebElement massage;



    @FindBy(partialLinkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignCurrency;
    @FindBy(id = "pc_currency")
    public WebElement currencySelect;
    @FindBy(id = "pc_amount")
    public WebElement amount;
    @FindBy(id = "pc_inDollars_true")
    public WebElement dollarRaadioBtn;
    @FindBy(id = "pc_inDollars_true")
    public WebElement selectCurrencyRadioBtn;
    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCost;

    public Select select(String feature){
        Select select=new Select(selectPayee);
        switch (feature){
            case "Payee":
            select=new Select(selectPayee);
             break;
            case "Account":
            select=new Select(selectAccount);
           break;
        }
        return select;
    }

    public WebElement addSomeThing(String featere){
        WebElement element= addAmount;
        switch (featere){
            case "Amount":
                element=addAmount;
                break;
            case "Date":
                element=dateInput;
                break;
            case  "Description":
                element=descriptionInput;
                break;
        }


        return element;
    }

}
