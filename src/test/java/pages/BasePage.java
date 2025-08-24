package pages;

import java.time.Duration;

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

    public void findElementByName(String name) {
        driver.findElement(By.name(name));
    }

    public WebElement findElementByLinkText(String text) {
        WebElement element = driver.findElement(By.linkText(text));
        return element;
    }

    public WebElement findElementById(String text) {
        WebElement element = driver.findElement(By.id(text));
        return element;
    }

    public WebElement findElementByXpath(String text) {
        WebElement element = driver.findElement(By.xpath(text));
        return element;
    }

    public WebElement findElementByClass(String text) {
        WebElement element = driver.findElement(By.className(text));
        return element;
    }

    public WebElement findElementByCSSSelector(String text) {
        WebElement element = driver.findElement(By.cssSelector(text));
        return element;
    }

    public void waitUntilLoaded(String expectedTitle) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.titleContains(expectedTitle));
    }

    public void waitUntilElementLocated(String text) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(By.linkText(text)));
    }
}