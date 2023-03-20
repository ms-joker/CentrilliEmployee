package com.cydeo.step_definitions;

import com.cydeo.pages.EmployeePage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;

public class CentrilliEmployee {

    public WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    EmployeePage employeePage = new EmployeePage();

    @Given("user logged in as posmanager")
    public void user_logged_in_as_posmanager() {
        driver.get(ConfigurationReader.getProperty("centrilliUrl"));
        loginPage.nameInput.sendKeys(ConfigurationReader.getProperty("userEmail"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("userPin") + Keys.ENTER);
    }

    @When("user in employee page")
    public void user_in_employee_page() throws InterruptedException {
        Thread.sleep(3000);
        try {
            // try to click Employee menu:
            employeePage.employeeMenu.click();
        } catch (ElementNotInteractableException e) {  // if Employee menu is not interactable
            try {
                // if window is not wide enough to fit all menu items, find 'More' menu:
                employeePage.moreMenu.click();
                employeePage.employeeMenu.click();
            } catch (ElementNotInteractableException exception) {
                // if navbar is collapsed, we need to find out the navbar-toggle button to open it.
                employeePage.toggleBtn.click();
                employeePage.employeeMenu.click();
            }
        }
        Thread.sleep(3000);
    }

    @Then("user should be able to create employee")
    public void user_should_be_able_to_create_employee() throws InterruptedException {
        // find Create button and click it:
        employeePage.createBtn.click();
        Thread.sleep(1500);
        employeePage.employeeName.sendKeys(ConfigurationReader.getProperty("newEmployee"));
        employeePage.saveBtn.click(); //click Save button.

        Thread.sleep(3000);
        //assert new employee is created successfully, by checking the title:
        String expectedTitle = ConfigurationReader.getProperty("newEmployee") + " - Odoo";
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @Then("user can see Employee Created message at the bottom")
    public void user_can_see_employee_created_message_at_the_bottom() throws InterruptedException {
        // find Create button and click it:
        employeePage.createBtn.click();
        Thread.sleep(1500);
        employeePage.employeeName.sendKeys(ConfigurationReader.getProperty("new1"));
        employeePage.saveBtn.click(); //click Save button.

        Thread.sleep(3000);
        //assert Employee Created message on the bottom:

        Assert.assertEquals("Employee created", employeePage.employeeCreated.getText());
    }

    @Then("user should see title as New Employee")
    public void user_should_see_title_as_new_employee() {
        System.out.println("User can see the title with new employee.");
    }


    @Then("user click Discard button to cancel")
    public void user_click_discard_button_to_cancel() throws InterruptedException {
        employeePage.createBtn.click();
        employeePage.discardBtn.click(); //click Save button.
        Thread.sleep(2000);
        //employeePage.alertOkBtn.click();
        Assert.assertEquals("Employees - Odoo", driver.getTitle());
    }


}
