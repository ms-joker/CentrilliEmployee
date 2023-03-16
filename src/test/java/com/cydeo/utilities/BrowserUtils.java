package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BrowserUtils {

    public static void sleep(int second){

    }

    public static void swithWindowAndVerify(String expectedInUrl, String expectedInTitle){

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each: allWindowsHandles){
            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl()     );

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle()  ;
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    public static void verifyTitle (String expectedTitle){
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }


}
