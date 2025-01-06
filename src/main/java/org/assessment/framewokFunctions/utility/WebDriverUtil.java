package org.assessment.framewokFunctions.utility;

import org.assessment.framewokFunctions.exceptionHandler.UserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverUtil {
    static WebDriverWait wait;
    static WebDriver driver;
    static PropertiesFileHandler config;
    static {
        try {
            config = new PropertiesFileHandler("config.properties");
        } catch (UserException e) {
            throw new RuntimeException(e);
        }
    }

    private static WebDriver getInstanceOfDriver() throws UserException {
        driver = createWebDriver(config.getValue("BROWSER"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return driver;
    }

    private static WebDriver createWebDriver(String browser)
    {
        System.out.println("Browser: " + browser);

        switch (browser.toLowerCase()) {
            case "ff":
            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "ch":
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            default:
                System.out.println("Invalid browser name " + browser);
                System.exit(0);
                break;
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        return driver;
    }

    public static WebDriver getDriver() throws UserException {
        if (driver == null) return getInstanceOfDriver();
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
