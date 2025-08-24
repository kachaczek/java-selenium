package pages;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {
    private WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
    }

    // Accept Google cookies
    public void acceptGoogleCookies() {
        try {
            findElementById("W0wltc").click();
        } catch (NoSuchElementException e) {
            System.out.println("Cookies not found");
        }
    }

    public void searchFor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.click();
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();
    }
}