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

    @FindBy(xpath = "//p[.='Employee created']")
    public WebElement employeeCreated;

    @FindBy(xpath = "//button[@accesskey='k']")
    public WebElement kanbanBtn;

    @FindBy(xpath = "//button[@accesskey='l']")
    public WebElement listBtn;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchBox;

    @FindBy(xpath = "//div[contains(@class,'o_kanban_view')]")
    public WebElement kanbanView;

    @FindBy(xpath = "//div[@class='table-responsive']")
    public WebElement listView;

    @FindBy(xpath = "//div[contains(@class,'o_kanban_record')]")
    public WebElement results;

    @FindBy(xpath = "//span[@class='o_pager_limit']")
    public WebElement numEmp;

    @FindBy(xpath="//div[contains(@class, 'pager')]//span[contains(@class, 'limit')]")
    public WebElement employees;


}
