package pages;

import org.openqa.selenium.WebDriver;

import tests.SearchTestHelper;

public class SearchPage extends BasePage implements SearchTestHelper {
    
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // Accept Google cookies
    public void acceptGoogleCookies() {
        findElementById(driver, "W0wltc").click();
    }
}
