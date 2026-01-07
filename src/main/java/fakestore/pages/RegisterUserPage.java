package pl.testelka.fakestore.pages;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testelka.fakestore.utils.DriverFactory;


import java.util.List;

public class RegisterUserPage {
//    Faker faker = new Faker();

    @FindBy(id = "reg_email")
    public WebElement usernameInput;

    @FindBy(id = "reg_email")
    public List <WebElement> usernameInputs;

    @FindBy(id = "reg_password")
    public WebElement passwordInput;

    @FindBy(name = "register")
    public List<WebElement> registerButtons;

    @FindBy(name = "register")
    public WebElement registerButton;

    @FindBy(className = "woocommerce-error")
    public WebElement errorRejestracji;

    public RegisterUserPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void registerUser (String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        for (int i = 0; i<3; i++) {
            if (registerButtons.size()>0) {
                registerButton.click();
            }
        }
    }


    public String geterrorRejestracjiText() {
        return errorRejestracji.getText();
    }

    public int getUsernameInputSize(){
        return usernameInputs.size();
    }
}
