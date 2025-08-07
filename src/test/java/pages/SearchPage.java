package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {
    
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // Search for some query
    public void searchFor(String query) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    // Accept Google cookies
    public void acceptGoogleCookiesIfPresent() {
        WebElement acceptCookieButton = driver.findElement(By.id("W0wltc"));
        acceptCookieButton.click();
    }
}
