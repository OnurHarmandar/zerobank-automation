package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

public class Date {
    public static void main(String[] args) {
        java.util.Date d1=new java.util.Date(2012,9,1);
        java.util.Date d2=new java.util.Date(2012,9,1);
        System.out.println("d1.compareTo(d2) = " + d1.compareTo(d2));


        System.out.println("d1.before(d2) = " + d1.before(d2));
        System.out.println("d1.after(d2) = " + d1.after(d2));
        System.out.println("d1.equals(d2) = " + d1.equals(d2));
/*
        String[] firstDate=dates.get(dates.size()-1).getText().split("-");
        int firstYear=Integer.parseInt(firstDate[0]);
        int firstMonth=Integer.parseInt(firstDate[1]);


        System.out.println("firstDate = " + firstDate[0].toString());

            getAttribute("validationMessage");
 */
    }
}
