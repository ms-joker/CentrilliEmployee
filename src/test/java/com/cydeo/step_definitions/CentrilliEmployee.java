package com.cydeo.step_definitions;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CentrilliEmployee {

    public WebDriver driver = Driver.getDriver();
    @Given("user logged in as posmanager")
    public void user_logged_in_as_posmanager() {
        driver.get(ConfigurationReader.getProperty("centrilliUrl"));
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys(ConfigurationReader.getProperty("userEmail"));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(ConfigurationReader.getProperty("userPin")+ Keys.ENTER);

//        System.out.println("User is logged in as posmanager.");
    }
    @When("user in employee page")
    public void user_in_employee_page() {
        driver.findElement(By.xpath("//a[@data-menu-xmlid='hr.menu_hr_root']")).click();
        Assert.assertEquals(driver.getTitle(), "Employee - Odoo");
//        System.out.println("User come to Employee page.");
    }
    @Then("user should be able to create employee")
    public void user_should_be_able_to_create_employee() {
        System.out.println("User is able to create employee.");
    }

}
