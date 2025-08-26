package tests;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.SeleniumDevPage;

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
        Assumptions.assumeTrue(true, "Selenium title");
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
        Assumptions.assumeTrue(true, "Events | Selenium");
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
        Assumptions.assumeTrue(true, "Getting started");
    }
}