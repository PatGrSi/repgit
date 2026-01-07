Feature: Rejestracja

    Background: Użytkownik znajduje się na stronie My Account
        Given Uzytkownik znajduje sie na stronie glownej sklepu
        When Przejscie do strony My Account

    Scenario: Rejestracja z poprawnym email i haslem
        And Wprowadzamy poprawne dane do formularza rejestracji
        Then Uzytkownik zostaje przekierowany do strony My Account
        But Nie jest widoczny formularz rejestracji uzytkownika


    Scenario Outline: Rejestracja z niepoprawnym email i haslem
        And Wprowadzamy niepoprawny "test@test.pl" oraz niepoprawne "<password>" do formularza rejestracji
        #And Wprowadzamy niepoprawne dane do formularza rejestracji
        Then Wywietlany jest komunikat o bledzie rejestracji

        Examples:
        |password|
        |AlaMaKota1!|
        |AlaMaKota1!AlaMaKota1!|
        |AlaMaKota1!AlaMaKota1!AlaMaKota1!|