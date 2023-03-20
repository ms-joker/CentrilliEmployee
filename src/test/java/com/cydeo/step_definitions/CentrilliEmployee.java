package com.cydeo.step_definitions;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;

public class CentrilliEmployee {

    public WebDriver driver = Driver.getDriver();

    @Given("user logged in as posmanager")
    public void user_logged_in_as_posmanager() {
        driver.get(ConfigurationReader.getProperty("centrilliUrl"));
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys(ConfigurationReader.getProperty("userEmail"));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(ConfigurationReader.getProperty("userPin") + Keys.ENTER);

//        System.out.println("User is logged in as posmanager.");
    }

    @When("user in employee page")
    public void user_in_employee_page() throws InterruptedException {
        try {
            // try to click Employee menu:
            driver.findElement(By.xpath("//a[@data-menu='157']")).click();
        } catch (ElementNotInteractableException e) {  // if Employee menu is not interactable
            try {
                // if window is not wide enough to fit all menu items, find 'More' menu:
                driver.findElement(By.xpath("//li[@id='menu_more_container']")).click();
                //driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();    //just in case
                // after find 'More' menu and click it, find Employee menu and click:
                driver.findElement(By.xpath("//a[@data-menu='157']")).click();
            } catch (ElementNotInteractableException exception) {
                // if navbar is collapsed, we need to find out the navbar-toggle button to open it.
                driver.findElement(By.xpath("//button[@class='navbar-toggle']")).click();
                // after open collapsed navbar, find Employee menu and click:
                driver.findElement(By.xpath("//a[@data-menu='157']")).click();
            }
        }
        Thread.sleep(3000);
        // After find Employee menu, assert if it is correct page:
        Assert.assertEquals("Employees - Odoo", driver.getTitle());
//        System.out.println("User come to Employee page.");
    }

    @Then("user should be able to create employee")
    public void user_should_be_able_to_create_employee() {
        // find Create button and click it:
        driver.findElement(By.xpath("//button[@accesskey='c']")).click();
        WebElement nameInput = driver.findElement(By.xpath("//input[@name='name']"));
        // input new employee name:
        nameInput.sendKeys(ConfigurationReader.getProperty("newEmployee"));
        driver.findElement(By.xpath("//button[@accesskey='s']")).click(); //click Save button.

        //Thread.sleep(3000);
        //assert new employee is created successfully, by checking the title:
        String expectedTitle = ConfigurationReader.getProperty("newEmployee")+ " - Odoo";
        Assert.assertEquals(expectedTitle, driver.getTitle());

    }

}
