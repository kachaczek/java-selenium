package tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.SeleniumDevPage;
import org.junit.jupiter.api.Assumptions;

public class SeleniumDevTest extends BaseTest {
    
    private SeleniumDevPage seleniumDevPage;

    @BeforeEach
    public void setUpPages() {
        seleniumDevPage = new SeleniumDevPage(driver);
    }

    @Test
    public void testDocumentation() {
        seleniumDevPage.openPage();
        seleniumDevPage.clickDocumentation();
        seleniumDevPage.waitUntilLoaded("Selenium");
        Assumptions.assumeTrue(true, "Selenium title");
    }

    @Test
    public void testAboutList() {
        seleniumDevPage.openPage();
        seleniumDevPage.clickOnEvents();
        seleniumDevPage.waitUntilLoaded("Events | Selenium");
        Assumptions.assumeTrue(true, "Events | Selenium");
    }

    @Test
    public void testGetGettingStarted() {
        seleniumDevPage.openPage();
        seleniumDevPage.clickGettingStarted();
        seleniumDevPage.waitUntilLoaded ("Getting started");
        Assumptions.assumeTrue(true, "Getting started");
    }
}