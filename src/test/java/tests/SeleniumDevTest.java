package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import pages.SeleniumDevPage;

public class SeleniumDevTest extends BaseTest implements SearchTestHelper {
    
    private SeleniumDevPage seleniumDevPage;

    @BeforeEach
    public void setUpPages() {
        seleniumDevPage = new SeleniumDevPage(driver);
    }

    @Test
    public void testDocumentation() {
        seleniumDevPage.openPage();
        findElementByLinkText(driver, "Documentation").click();
        waitUntilLoaded(driver, "Selenium");
        assumeCondition(true, "Selenium title");
    }

    @Test
    public void testAboutList() {
        seleniumDevPage.openPage();

        WebElement element = findElementById(driver, "navbarDropdown");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        waitUntilElementLocated(driver, "Events");
        driver.findElement(By.linkText("Events")).click();
    }

    @Test
    public void testGetGettingStarted() {
        seleniumDevPage.openPage();
        findElementById(driver, "m-documentationwebdrivergetting_started").click();
        waitUntilLoaded (driver, "Getting started");
    }
}