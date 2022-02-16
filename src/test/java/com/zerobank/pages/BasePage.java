package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

        @FindBy(partialLinkText = "Account Summary")
        @CacheLookup
        protected WebElement accountSummary;

        @FindBy(partialLinkText = "Account Activity")
        public WebElement accountActivity;

        @FindBy(partialLinkText = "Transfer Funds")
        public WebElement transferBunds;

        @FindBy(partialLinkText = "Pay Bills")
        public WebElement payBils;

        @FindBy(partialLinkText = "My Money Map")
        public WebElement mayMoneyMap;

        @FindBy(partialLinkText = "Online Statements")
        public WebElement onlineStatements;

        @FindBy(className = "dropdown-toggle")
        public WebElement userName;

        @FindBy(id = "logout_link")
        public WebElement logOutLink;

        public BasePage() {
            PageFactory.initElements(Driver.get(), this);
        }


        /**
         * @return page name, for example: Dashboard
         */



        /**
         * Waits until loader screen present. If loader screen will not pop up at all,
         * NoSuchElementException will be handled  bu try/catch block
         * Thus, we can continue in any case.
         */
        public void waitUntilLoaderScreenDisappear() {
            try {
                WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
                wait.until(ExpectedConditions.invisibilityOf(accountSummary));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public String getUserName(){
            waitUntilLoaderScreenDisappear();
            BrowserUtils.waitForVisibility(userName, 5);
            return userName.getText();
        }



        public void logOut(){
            BrowserUtils.waitFor(2);
            BrowserUtils.clickWithJS(userName);
            BrowserUtils.clickWithJS(logOutLink);
        }

    public void navigateTo(String tab) {
        String tabLocator = tab;
        //     String moduleLocator2 = "//span[@class='title title-level-1' and contains(text(),'"+ module + "')]";

        try {
            BrowserUtils.waitForClickablility(By.partialLinkText(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.partialLinkText(tab));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.partialLinkText(tabLocator), 5);
        }
    }


    }
