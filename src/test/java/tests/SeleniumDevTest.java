package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import pages.SeleniumDevPage;

public class SeleniumDevTest extends BaseTest {
    
    private SeleniumDevPage seleniumDevPage;

    @BeforeEach
    public void setUpPages() {
        seleniumDevPage = new SeleniumDevPage(driver);
    }

    @Test
    public void testDocumentation() {
        seleniumDevPage.openPage();
        seleniumDevPage.findElementByLinkText(driver, "Documentation").click();
        seleniumDevPage.waitUntilLoaded(driver, "Selenium");
        seleniumDevPage.assumeCondition(true, "Selenium title");
    }

    @Test
    public void testAboutList() {
        seleniumDevPage.openPage();

        WebElement element = seleniumDevPage.findElementById(driver, "navbarDropdown");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        seleniumDevPage.waitUntilElementLocated(driver, "Events");
        driver.findElement(By.linkText("Events")).click();
    }

    @Test
    public void testGetGettingStarted() {
        seleniumDevPage.openPage();
        seleniumDevPage.findElementById(driver, "m-documentationwebdrivergetting_started").click();
        seleniumDevPage.waitUntilLoaded (driver, "Getting started");
    }
}