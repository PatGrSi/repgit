package pl.testelka.fakestore.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {
    public static void waitForElementExist(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), java.time.Duration.ofSeconds(10));
        wait.until(driver -> driver.findElements(locator).size() > 0);
    }
}
