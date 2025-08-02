package tests;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {

    private WebDriver driver;
    private SearchPage searchPage;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testBingSearch() {
        driver.get("https://www.bing.com");
        searchPage.searchFor("Selenium WebDriver");
        searchPage.waitForTitleToContain("Selenium WebDriver");
    }

    @Test
    public void testDuckDuckGoSearch() {
        driver.get("https://duckduckgo.com/");
        searchPage.searchFor("Selenium WebDriver");
        searchPage.waitForTitleToContain("Selenium WebDriver");
    }

    // Google detects that web browser was used too many times with the same behaviour. Security check reCAPTCHA searchbox is shown
    // and later reCaptcha shows few photos to choose as Google detects an automated behaviour of Selenium
    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");

        searchPage.acceptGoogleCookiesIfPresent();
        searchPage.searchFor("Selenium WebDriver");
        searchPage.webdriverWait();

        boolean isRecaptchaPresent = false;

        try {
            isRecaptchaPresent = driver.findElement(By.id("recaptcha")).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Recaptcha element not found. Proceeding with the test.");
        }

        if (isRecaptchaPresent) {
            System.out.println("reCaptcha element found. Skipping the test.");
            searchPage.assumeTrue("Test shipped due to reCaptcha");
            return;
        }

        searchPage.searchFor("Selenium WebDriver");
        searchPage.waitForTitleToContain("Selenium WebDriver");
    }
    
    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}