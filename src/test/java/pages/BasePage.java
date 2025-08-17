package pages;

import java.time.Duration;

import org.junit.jupiter.api.Assumptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void findElementByName(WebDriver driver, String name) {
        driver.findElement(By.name(name));
    }
    
    public void searchByName(WebDriver driver, String query, String address) {
        WebElement element = driver.findElement(By.name(address));
        element.sendKeys(query);
        element.submit();
    }

    public WebElement findElementByLinkText(WebDriver driver, String text) {
        WebElement element = driver.findElement(By.linkText(text));
        return element;
    }

    public WebElement findElementById(WebDriver driver, String text) {
        WebElement element = driver.findElement(By.id(text));
        return element;
    }

    public void searchAndSendKeys(WebDriver driver, String name, String query) {
        WebElement searchBox = driver.findElement(By.name(name));
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    public void waitUntilLoaded(WebDriver driver, String expectedTitle) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.titleContains(expectedTitle));
    }

    public void waitUntilElementLocated(WebDriver driver, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.visibilityOfElementLocated(By.linkText(text)));
    }

    public void assumeCondition(boolean condition, String message) {
        if (condition) {
            Assumptions.assumeTrue(condition, message);
        } else {
            Assumptions.assumeFalse(condition, message);
        }
    }
}