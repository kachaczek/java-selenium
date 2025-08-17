package pages;

import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // Accept Google cookies
    public void acceptGoogleCookies() {
        findElementById(driver, "W0wltc").click();
    }
}
