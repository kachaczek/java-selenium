package tests;

import java.time.Duration;

import org.junit.jupiter.api.Assumptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driver;
    
    public SearchPage( WebDriver driver) {
        this.driver = driver;
    }

    // search for some query
    public void searchFor(String query) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    // Check if expected string will be shown
    public void waitForTitleToContain(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(expectedTitle));
    }

    // Accept Google cookies
    public void acceptGoogleCookiesIfPresent() {
        WebElement acceptCookieButton = driver.findElement(By.id("W0wltc"));
        acceptCookieButton.click();
    }

    public void webdriverWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void testSkipped(String message) {
        Assumptions.assumeTrue(false, message);
    }
}
