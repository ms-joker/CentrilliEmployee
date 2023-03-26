package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalendarTest {

    public static WebDriver driver = Driver.getDriver();

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://qa.centrilli.com/");
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys("posmanager15@info.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("posmanager");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        driver.findElement(By.partialLinkText("Calendar")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(@class, 'fc')]")).click();
        driver.findElement(By.xpath("//button/span[.='Edit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@name='start_date']")).click();

        WebElement cal = driver.findElement(By.xpath("//div[contains(@class, 'bootstrap-datetimepicker-widget')]"));
        System.out.println("cal = " + cal.getText());

        List<WebElement> dates = driver.findElements(By.xpath("//div[contains(@class, 'bootstrap-datetimepicker-widget')]//td"));
        for (WebElement day: dates) {
            System.out.println(day.getText());
        }
        //System.out.println(dates.size());

    }

}
