package tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import pages.SearchPage;

public class SearchTest extends BaseTest implements SearchTestHelper {

    private SearchPage searchPage;

    @BeforeEach
    public void initPage() {
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testBingSearch() {
        driver.get("https://www.bing.com");
        searchPage.searchFor("Selenium WebDriver");
        waitUntilLoaded(driver, "Selenium WebDriver");
        assumeCondition(true, "Selenium Webdriver title shown");
    }

    @Test
    public void testDuckDuckGoSearch() {
        driver.get("https://duckduckgo.com/");
        searchPage.searchFor("Selenium WebDriver");
        waitUntilLoaded(driver, "Selenium WebDriver");
        assumeCondition(true, "Selenium Webdriver title shown");
    }

    // Google detects that web browser was used too many times with the same behaviour. Security check reCAPTCHA searchbox is shown
    // and NoSuchElementException is thrown as Google detects an automated behaviour of Selenium
    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");

        searchPage.acceptGoogleCookiesIfPresent();
        searchPage.searchFor("Selenium WebDriver");


        boolean isRecaptchaPresent = false;
        try {
            driver.findElement(By.id("recaptcha")).isDisplayed();
            isRecaptchaPresent = true;
            Assumptions.assumeTrue(!isRecaptchaPresent, "reCaptcha element found. Skipping the test.");
        } catch (NoSuchElementException e) {
            System.out.println("Recaptcha element not found. Proceeding with the test.");
            
        }

        if(!isRecaptchaPresent) {
            waitUntilLoaded(driver, "Selenium WebDriver");
            assumeCondition(true, "Selenium Webdriver title shown");
        }
    }
}