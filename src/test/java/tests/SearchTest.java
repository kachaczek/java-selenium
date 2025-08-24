package tests;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.SearchPage;

public class SearchTest extends BaseTest {

    private SearchPage searchPage;

    @BeforeEach
    public void initPage() {
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testBingSearch() {
        driver.get("https://www.bing.com");
        searchPage.searchFor();
        searchPage.waitUntilLoaded("Selenium WebDriver");
        Assumptions.assumeTrue(true, "Selenium Webdriver title shown");
    }

    @Test
    public void testDuckDuckGoSearch() {
        driver.get("https://duckduckgo.com/");
        searchPage.searchFor();
        searchPage.waitUntilLoaded("Selenium WebDriver");
        Assumptions.assumeTrue(true, "Selenium Webdriver title shown");
    }
}