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
        driver.get("https://www.selenium.dev/documentation/webdriver/");
        findElementByLinkText(driver, "Documentation").click();
        waitUntilLoaded(driver, "Selenium");
        assumeCondition(true, "Selenium title");
    }

    @Test
    public void testAboutList() {
        driver.get("https://www.selenium.dev/documentation/webdriver/");
        WebElement element = driver.findElement(By.id("navbarDropdown"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        waitUntilElementLocated(driver, "Events");
        driver.findElement(By.linkText("Events")).click();
    }
}
