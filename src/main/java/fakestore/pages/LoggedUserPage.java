package pl.testelka.fakestore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testelka.fakestore.utils.DriverFactory;
import pl.testelka.fakestore.utils.SeleniumHelper;

public class LoggedUserPage {

        @FindBy(linkText = "Wyloguj")
        public WebElement logoutLink;

        public LoggedUserPage() {
            PageFactory.initElements(DriverFactory.getDriver(), this);
        }

        public boolean checkIfLogoutLinkIsDisplayed() {
            SeleniumHelper.waitForElementExist(By.linkText("Wyloguj"));
            return logoutLink.isDisplayed();
        }
}
