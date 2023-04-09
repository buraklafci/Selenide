package stepdefinitions;

import io.cucumber.java.en.*;
import pages.TestPage;

public class TestPageStepDefinitions {
    TestPage testPage=new TestPage();
    @Given("I enter username")
    public void ı_enter_username() {
        testPage.username.setValue("techproed");
        //seleniumdaki sendKeys yerine setValue kullanilir
    }
    @Given("I enter password")
    public void ı_enter_password() {
    testPage.password.setValue("SuperSecretPassword");

    }
    @Given("I enter submit button")
    public void ı_enter_submit_button() {
        testPage.submitButton.click();
    }
    @Given("I click on logout link")
    public void ı_click_on_logout_link() {
        testPage.logout.click();
    }
}
