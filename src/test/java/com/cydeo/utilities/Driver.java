package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){};

    private static WebDriver driver;    // value is null by default.

    public static WebDriver getDriver(){

        /**
         *
         * option.addArguments("--remote-allow-origins=*");
         * if (driver == null){
         *      if(System.getProperty("BROWSER"==null){
         *          browser = ConfigurationReader.getProperty("browser");
         *      } else {
         *          browser = System.getProperty("BROWSER")
         *      }
         *      System.out.println("Broswer: " + browser );
         *      switch(browser){
         *          case "remote-chrome":
         *              try {
         *                  String gridAddress = ""     //ip address
         *                  URL url = URL("https://" + gridAddress + ":4444/wd/hub");
         *                  DesiredCapabilities desiredCapabilities = new De
         *                  desiredCapabilites.setBrowserName("chrome");
         *                  driver = new RemoteWebDriver(url, desiredCapabilities);
         *              } catch (Exception e){
         *                  e.printStackTrace();
         *              }
         *              break;
         *          case "chrome":
         *              WebDriverManager.chromedriver().setup();
         *              driver = new ChromeDriver(option);
         *              break;
         *          case "chrome-headless":
         *              WebDriverManager.chromedriver().setup();
         *              driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
         *              break;
         *          case "fire-fox":
         *              WebDriverManager.firefoxdriver().setup();
         *              driver = new FirefoxDriver(option);
         *              break;
         *       }
         *
         *
         *
         *
         */

        if (driver == null){

            String browser = ConfigurationReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    break;
            }
        }

        return driver;
    }


    public static void closeDriver(){
        if (driver!= null) {
            driver.quit();  //terminate the driver.
            driver = null;

        }
    }



}
