package runner;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testelka.fakestore.pages.HomePage;
import pl.testelka.fakestore.pages.LoggedUserPage;
import pl.testelka.fakestore.pages.RegisterUserPage;
import pl.testelka.fakestore.utils.DriverFactory;
import pl.testelka.fakestore.utils.SeleniumHelper;

@Test
@CucumberOptions(
        features = "src/test/resources",
        glue = "runner",
        plugin = {"pretty"}
)


public class TestSteps {

    private HomePage homePage;
    private LoggedUserPage LoggedUserPage;

    @After
    public void driveDown(){
        DriverFactory.quitDriver();
    }



    @Given("Uzytkownik znajduje sie na stronie glownej sklepu")
    public void uzytkownik_znajduje_sie_na_stronie_glownej_sklepu() {
        System.out.println("1");
        homePage = new HomePage();
        homePage.openHomePage();

    }

    @When("Przejscie do strony My Account")
    public void przejscieDoStronyMyAccount() {
        homePage.goToMyAccountPage();
        System.out.println("2");
    }

    @And("Wprowadzamy poprawne dane do formularza rejestracji")
    public void wprowadzamyPoprawneDaneDoFormularzaRejestracji() {
        RegisterUserPage registerUserPage = new RegisterUserPage();
        Faker faker = new Faker();
        registerUserPage.registerUser(faker.internet().emailAddress(), faker.internet().password());
        System.out.println("3");
    }

    @Then("Uzytkownik zostaje przekierowany do strony My Account")
    public void uzytkownikZostajePrzekierowanyDoStronyMyAccount() {
        LoggedUserPage LoggedUserPage = new LoggedUserPage();

        Assert.assertTrue(LoggedUserPage.checkIfLogoutLinkIsDisplayed());
        System.out.println("4");
    }

    @But("Nie jest widoczny formularz rejestracji uzytkownika")
    public void nieJestWidocznyFormularzRejestracjiUzytkownika() {
        RegisterUserPage registerUserPage = new RegisterUserPage();
        Assert.assertTrue(registerUserPage.getUsernameInputSize() == 0, "Formularz rejestracji jest widoczny");
        System.out.println("5");

    }

    @And("Wprowadzamy niepoprawne dane do formularza rejestracji")
    public void wprowadzamyNiepoprawneDaneDoFormularzaRejestracji() {
        RegisterUserPage registerUserPage = new RegisterUserPage();
        registerUserPage.registerUser("test@test.pl", "AlaMaKotaIPsa123!");
        System.out.println("6");
    }

    @Then("Wywietlany jest komunikat o bledzie rejestracji")
    public void wywietlanyJestKomunikatOBledzieRejestracji() {
        RegisterUserPage registerUserPage = new RegisterUserPage();
        Assert.assertTrue(registerUserPage.geterrorRejestracjiText().contains("Błąd: Konto jest już zarejestrowane w test@test.pl. Zaloguj się lub użyj innego adresu e-mail."));
        System.out.println("7");
    }

    @And("Wprowadzamy niepoprawny {string} oraz niepoprawne {string} do formularza rejestracji")
    public void wprowadzamyNiepoprawnyOrazNiepoprawneDoFormularzaRejestracji(String wrongEmail, String wrongPassword) {
        RegisterUserPage registerUserPage = new RegisterUserPage();
        registerUserPage.registerUser(wrongEmail, wrongPassword);
        System.out.println("6");
    }

}
