package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {
    public EmployeePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement createBtn;

    @FindBy(xpath = "//input[@placeholder='Search...']")
    public WebElement searchInput;

    @FindBy(xpath = "//a[@data-menu='157']")
    public WebElement employeeMenu;

    @FindBy(xpath = "//li[@id='menu_more_container']")
    public WebElement moreMenu;

    @FindBy(xpath = "//button[@class='navbar-toggle']")
    public WebElement toggleBtn;

    @FindBy(xpath = "//input[@name='name']")
//    @FindBy(xpath = "//input[@id='o_field_input_1197']")
    public WebElement employeeName;

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement saveBtn;

    @FindBy(xpath = "//button[@accesskey='a']")
    public WebElement editBtn;

    @FindBy(xpath = "//button[@accesskey='j']")
    public WebElement discardBtn;

    @FindBy(xpath = "//div[@class='modal-dialog']//button[1]")
    public WebElement alertOkBtn;

    @FindBy(xpath = "//p[.='Employee created']")
    public WebElement employeeCreated;



}
