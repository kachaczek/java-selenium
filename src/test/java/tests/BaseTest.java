package tests;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import pages.SearchPage;
import pages.SeleniumDevPage;

/**
 * BaseTest is a class providing setup and teardown for Selenium WebDriver tests.
 * It initializes the browser driver (Chrome or Firefox), manages browser options,
 * and creates shared page object instances for use in test classes.
 */
public class BaseTest {
    protected WebDriver driver;
    protected SearchPage searchPage;
    protected SeleniumDevPage seleniumDevPage;

    @BeforeEach
    public void setup() {

        WebDriverManager.chromedriver().setup();

        String browser = System.getProperty("browser", "chrome");
        if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");
            driver = new FirefoxDriver(options);
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
        }

        searchPage = new SearchPage(driver);
        seleniumDevPage = new SeleniumDevPage(driver);
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) throws IOException {
        if (driver != null) {
            boolean failed = testInfo.getTags().contains("failed");

            // screenshot will be captured on Test Failure
            if (failed) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Screenshot on Failure",
                        new ByteArrayInputStream(screenshot));
            }
            driver.quit();
        }
    }
}