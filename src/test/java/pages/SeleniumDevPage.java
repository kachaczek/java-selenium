package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDevPage extends BasePage {

    public SeleniumDevPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://www.selenium.dev/documentation/webdriver/");
    }

    public void clickDocumentation() {
        findElementByCSSSelector("a.nav-link[href='/documentation']").click();
    }

    public void clickGettingStarted() {
        findElementById("m-documentationwebdrivergetting_started").click();
    }

    public void clickOnEvents() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dropdown = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("navbarDropdown"))
        );
        dropdown.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement eventsLink = wait.until(
            ExpectedConditions.elementToBeClickable(By.cssSelector("a.dropdown-item[href='/events']"))
        );
        eventsLink.click();
    }
}