package pl.testelka.fakestore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testelka.fakestore.utils.DriverFactory;

public class HomePage {
    @FindBy(xpath = "\"menu-item-201\"")
    public WebElement myAccountLink;

    public void goToMyAccountPage() {
        myAccountLink.click();
    }

    public HomePage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }
    public void openHomePage() {
        DriverFactory.getDriver().get("https://fakestore.testelka.pl/");
    }

}
