package pages;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * SearchPage encapsulates actions and element interactions for search engine pages (e.g., Bing, DuckDuckGo).
 * It provides methods to perform searches, wait for results, and interact with search-related elements.
 * Used by UI test classes to automate search scenarios.
 */
public class SearchPage extends BasePage {
    private WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchFor(String query) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        searchBox.click();
        searchBox.sendKeys(query);
        searchBox.submit();
    }
}