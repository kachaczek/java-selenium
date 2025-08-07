package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.junit.jupiter.api.Assumptions;

public interface SearchTestHelper {

    default void findElementByName(WebDriver driver, String name) {
        driver.findElement(By.name(name));
    }
    
    default void searchByName(WebDriver driver, String query, String address) {
        WebElement element = driver.findElement(By.name(address));
        element.sendKeys(query);
        element.submit();
    }

    default WebElement findElementByLinkText(WebDriver driver, String text) {
        WebElement element = driver.findElement(By.linkText(text));
        return element;
    }

    default WebElement findElementById(WebDriver driver, String text) {
        WebElement element = driver.findElement(By.id(text));
        return element;
    }

    default void searchFor(WebDriver driver, String query) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    default void waitUntilLoaded(WebDriver driver, String expectedTitle) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.titleContains(expectedTitle));
    }

    default void waitUntilElementLocated(WebDriver driver, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.visibilityOfElementLocated(By.linkText(text)));
    }

    default void assumeCondition(boolean condition, String message) {
        if (condition) {
            Assumptions.assumeTrue(condition, message);
        } else {
            Assumptions.assumeFalse(condition, message);
        }
    }
}