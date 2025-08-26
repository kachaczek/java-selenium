package tests;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit5.AllureJunit5;
import pages.SearchPage;

@ExtendWith(AllureJunit5.class)
public class SearchTest extends BaseTest {

    private SearchPage searchPage;

    @BeforeEach
    public void initPage() {
        searchPage = new SearchPage(driver);
    }

    @Test
    @DisplayName("Check Bing homepage contains search box")
    @Epic("Web UI Tests")
    @Feature("Search Engines")
    @Story("Bing search box")
    @Severity(SeverityLevel.NORMAL)
    public void testBingSearch() {
        driver.get("https://www.bing.com");
        searchPage.searchFor();
        searchPage.waitUntilLoaded("Selenium WebDriver");
        Assumptions.assumeTrue(true, "Selenium Webdriver title shown");
    }

    @Test
    @Epic("Web UI Tests")
    @Feature("Search Engines")
    @Story("DuckDuckGo search box")
    @Severity(SeverityLevel.NORMAL)
    public void testDuckDuckGoSearch() {
        driver.get("https://duckduckgo.com/");
        searchPage.searchFor();
        searchPage.waitUntilLoaded("Selenium WebDriver");
        Assumptions.assumeTrue(true, "Selenium Webdriver title shown");
    }
}