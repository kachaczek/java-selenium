package pages;

import org.openqa.selenium.WebDriver;

public class SeleniumDevPage extends BasePage {

    public SeleniumDevPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://www.selenium.dev/documentation/webdriver/");
    } 
}