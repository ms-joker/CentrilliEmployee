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



    @Given("user go to employee page")
    public void user_go_to_employee_page() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("centrilliUrl"));
        loginPage.nameInput.sendKeys(ConfigurationReader.getProperty("userEmail"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("userPin") + Keys.ENTER);
        Thread.sleep(3000);
        try {
            // try to click Employee menu:
            employeePage.employeeMenu.click();
        } catch (Exception e) {  // if Employee menu is not interactable
            try {
                // if window is not wide enough to fit all menu items, find 'More' menu:
                employeePage.moreMenu.click();
                employeePage.employeeMenu.click();
            } catch (Exception exception) {
                // if navbar is collapsed, we need to find out the navbar-toggle button to open it.
                employeePage.toggleBtn.click();
                employeePage.employeeMenu.click();
            }
        }
        Thread.sleep(3000);
    }
    @When("user click create button")
    public void user_click_create_button() throws InterruptedException {
        // find Create button and click it:
        employeePage.createBtn.click();
        Thread.sleep(1500);
        employeePage.employeeName.sendKeys(ConfigurationReader.getProperty("newEmployee"));
        employeePage.saveBtn.click(); //click Save button.
    }
    @Then("user should be able to create employee")
    public void user_should_be_able_to_create_employee() throws InterruptedException {
        Thread.sleep(3000);
        //assert new employee is created successfully, by checking the title:
        String expectedTitle = ConfigurationReader.getProperty("newEmployee") + " - Odoo";
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @When("user click discard button")
    public void user_click_discard_button() {
        employeePage.createBtn.click();
        employeePage.discardBtn.click(); //click Save button.
    }
    @Then("user can cancel creating")
    public void user_can_cancel_creating() throws InterruptedException {
        Thread.sleep(2000);
        //employeePage.alertOkBtn.click();
        Assert.assertEquals("Employees - Odoo", driver.getTitle());
    }

    @When("user click save without entering employee name")
    public void user_click_save_without_entering_employee_name() throws InterruptedException {
        employeePage.createBtn.click();
        Thread.sleep(1500);
//        employeePage.employeeName.sendKeys(ConfigurationReader.getProperty("newEmployee"));
        employeePage.saveBtn.click(); //click Save button.
    }
    @Then("user should not creating employee")
    public void user_should_not_creating_employee() throws InterruptedException {
        Thread.sleep(2000);
        //employeePage.alertOkBtn.click();
        Assert.assertEquals("New - Odoo", driver.getTitle());
    }

    @Then("user should see title as New Employee")
    public void user_should_see_title_as_new_employee() throws InterruptedException {
        Thread.sleep(3000);
        //assert new employee is created successfully, by checking the title:
        String expectedTitle = ConfigurationReader.getProperty("newEmployee") + " - Odoo";
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }
    @Then("user can see Employee Created message at the bottom")
    public void user_can_see_employee_created_message_at_the_bottom() throws InterruptedException {
        Thread.sleep(3000);
        //assert Employee Created message on the bottom:
        Assert.assertEquals("Employee created", employeePage.employeeCreated.getText());
    }

    @When("user search the employee")
    public void user_search_the_employee() {
        employeePage.searchBox.sendKeys("John_Wick" + Keys.ENTER);
        System.out.println("User enter a name ");
    }
    @Then("user can locate the new employee created by search")
    public void user_can_locate_the_new_employee_created_by_search() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("user click kanban icon")
    public void user_click_kanban_icon() {
        System.out.println("User clicked the 'Kanban' button.");
    }
    @Then("user can see the table as kanban")
    public void user_can_see_the_table_as_kanban() {
        System.out.println("User can see the kanban");
    }

    @When("user click list icon")
    public void user_click_list_icon() {
        System.out.println("User clicked the 'List' button.");
    }
    @Then("user can see the table as list")
    public void user_can_see_the_table_as_list() {
        System.out.println("User can see the list.");
    }



}
