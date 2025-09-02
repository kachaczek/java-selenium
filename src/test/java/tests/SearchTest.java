package tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit5.AllureJunit5;
import pages.SearchPage;

/**
 * SearchTest contains parameterized UI tests for search engines (Bing, DuckDuckGo).
 * It verifies that searching for a keyword returns expected results in the browser title.
 * Allure annotations are used for reporting.
 */
@ExtendWith(AllureJunit5.class)
public class SearchTest extends BaseTest {

    private SearchPage searchPage;

    @BeforeEach
    public void initPage() {
        searchPage = new SearchPage(driver);
    }

    @ParameterizedTest
    @CsvSource({
        "https://www.bing.com, Bing search box",
        "https://duckduckgo.com/, DuckDuckGo search box"
    })
    @DisplayName("Check search results on multiple engines")
    @Epic("Web UI Tests")
    @Feature("Search Engines")
    @Severity(SeverityLevel.NORMAL)
    public void testShouldShowSearchResultsOnSearchEngines(String url) {
        driver.get(url);
        searchPage.searchFor("Selenium WebDriver");
        searchPage.waitUntilLoaded("Selenium WebDriver");
        String actualTitle = driver.getTitle();
        boolean titleMatches = actualTitle.contains("Selenium WebDriver");
        Assertions.assertTrue(titleMatches, "Selenium WebDriver");
        Assumptions.assumeTrue(titleMatches, "Expected title not shown: " + actualTitle);
        Assertions.assertFalse(driver.getTitle().contains("Selenium WebDriver is not shown"));
    }
}