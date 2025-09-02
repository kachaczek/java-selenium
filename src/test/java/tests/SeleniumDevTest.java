package tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.SeleniumDevPage;

/**
 * SeleniumDevTest automates navigation and interaction with the Selenium documentation website.
 * It verifies page navigation, dropdown lists, and getting started documentation using SeleniumDevPage.
 * Allure annotations are used for reporting.
 */
public class SeleniumDevTest extends BaseTest {
    
    private SeleniumDevPage seleniumDevPage;

    @BeforeEach
    public void setUpPages() {
        seleniumDevPage = new SeleniumDevPage(driver);
    }

    @Test
    @Epic("Web UI Tests")
    @Feature("Search Engines")
    @Story("Selenium Webdriver Documentation page")
    @Severity(SeverityLevel.NORMAL)
    public void testDocumentation() {
        seleniumDevPage.openPage();
        seleniumDevPage.clickDocumentation();
        seleniumDevPage.waitUntilLoaded("Selenium");
        String actualTitle = driver.getTitle();
        boolean titleMatches = actualTitle.contains("Selenium");
        Assertions.assertTrue(titleMatches, "Expected title not shown: " + actualTitle);
        Assertions.assertFalse(actualTitle.contains("Selenium is not shown"));
    }

    @Test
    @Epic("Web UI Tests")
    @Feature("Search Engines")
    @Story("Selenium WebDriver drop down list")
    @Severity(SeverityLevel.NORMAL)
    public void testAboutList() {
        seleniumDevPage.openPage();
        seleniumDevPage.clickOnEvents();
        seleniumDevPage.waitUntilLoaded("Events | Selenium");
        String actualTitle = driver.getTitle();
        boolean titleMatches = actualTitle.contains("Events | Selenium");
        Assertions.assertTrue(titleMatches, "Expected title not shown: " + actualTitle);
        Assertions.assertFalse(actualTitle.contains("Events of Selenium is not shown"));
    }

    @Test
    @Epic("Web UI Tests")
    @Feature("Search Engines")
    @Story("Selenium WebDriver Getting Started page")
    @Severity(SeverityLevel.NORMAL)
    public void testGetGettingStarted() {
        seleniumDevPage.openPage();
        seleniumDevPage.clickGettingStarted();
        seleniumDevPage.waitUntilLoaded ("Getting started");
        String actualTitle = driver.getTitle();
        boolean titleMatches = actualTitle.contains("Getting started");
        Assertions.assertTrue(titleMatches, "Expected title not shown: " + actualTitle);
        Assertions.assertFalse(actualTitle.contains("Getting started with Selenium"));
    }
}