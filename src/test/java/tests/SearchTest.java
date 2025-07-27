package tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {

    private WebDriver driver;

    void findElement() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();
    }

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testBingSearch() {
        driver.get("https://www.bing.com");

        findElement();

        assertEquals(driver.getTitle().contains("Selenium WebDriver"), driver.getTitle().contains("Selenium WebDriver"));
        assertTrue(driver.getTitle().contains("Selenium WebDriver")); 
    }

    @Test
    public void testDuckDuckGoSearch() {
        driver.get("https://duckduckgo.com/");

        findElement();

        // Wait for the results to load (optional, but helps avoid flaky tests)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Selenium WebDriver"));

        // Assert that the title contains "Selenium WebDriver"
        String title = driver.getTitle();
        assertTrue(title.contains("Selenium WebDriver"), "Title should contain 'Selenium WebDriver', but was: " + title);

        assertEquals(driver.getTitle().contains("Selenium WebDriver"), driver.getTitle().contains("Selenium WebDriver"));
    }

    // This test can fail, when Google detects that web browser was used to many times with the same behaviour.
    // If there is shown 'I'm not a robot' check box, that is not possible to check this security reCAPTCHTA as Google
    // detects an automated behaviour of Selenium. Only the real humam can get around reCAPTCHA by clicking the checkbox.
    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");

        // Accepting Google cookies
        WebElement acceptCookieButton = driver.findElement(By.id("W0wltc"));
        acceptCookieButton.click();

        findElement();

        // uncomment if Test class run only once
        // assertEquals(driver.getTitle().contains("Selenium WebDriver"), driver.getTitle().contains("Selenium WebDriver"));
    }
    
    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}