package stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.*;
import pages.TestPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.switchTo;


public class TestPageStepDefinitions {
    TestPage testPage = new TestPage();

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

    //Checkbox_radio
    @Given("I click on {string} if not already selected")
    public void ı_click_on_if_not_already_selected(String string) {
        if (string.equals("Checkbox 1") && !testPage.checkbox1.isSelected()) {
            testPage.checkbox1.shouldNotBe(checked);
            testPage.checkbox1.click();
            testPage.checkbox1.shouldBe(checked);
        } else if (string.equals("Checkbox 2") && !testPage.checkbox2.isSelected()) {
            testPage.checkbox2.shouldNotBe(checked);
            testPage.checkbox2.click();
            testPage.checkbox2.shouldBe(checked);
        } else if (string.equals("red") && !testPage.red.isSelected()) {
            testPage.red.shouldNotBe(checked);
            testPage.red.click();
            testPage.red.shouldBe(checked);
        } else if (string.equals("yellow") && !testPage.yellow.isSelected()) {
            testPage.yellow.shouldNotBe(checked);
            testPage.yellow.click();
            testPage.yellow.shouldBe(checked);
        } else if (string.equals("football") && !testPage.football.isSelected()) {
            testPage.football.shouldNotBe(checked);
            testPage.football.click();
            testPage.football.shouldBe(checked);
        }
    }

    @Given("I select the year as {int}")
    public void ı_select_the_year_as(Integer int1) {
        testPage.year.selectOption(String.valueOf(int1));
    }

    @Given("I select the months as {string}")
    public void ı_select_the_months_as(String string) {
        testPage.month.selectOption(string);
    }

    @Given("I select the day as {int}")
    public void ı_select_the_day_as(Integer int1) {
        testPage.day.selectOption(int1 - 1);//    index'ten dolayi -1
    }

    @And("I get the list of US states and click on {string}")
    public void ıGetTheListOfUSStatesAndClickOn(String str) {
    testPage.listOfStates.forEach(state-> System.out.println(state.getText()));
        for (SelenideElement states : testPage.listOfStates
        ) {
            if (states.getText().equals(str)) {
                states.click();

                break;
            }
        }
    }

    @And("I click on alert prompt")
    public void ıClickOnAlertPrompt() {
     testPage.jsPromptButton.click();
    }

    @And("I enter {string} and click OK")
    public void ıEnterAndClickOK(String str) {
        WebDriverRunner.getWebDriver().switchTo().alert().sendKeys(str);
        //switchTo().alert().sendKeys(str); //seklinde olabilir
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
    }

    @Then("I verify the result contains {string}")
    public void ıVerifyTheResultContains(String str) {
        testPage.resultAlert.shouldHave(Condition.text(str));
    }

    @Given("I verify the page header contains {string}")
    public void ı_verify_the_page_header_contains(String string) {
       //is outside of iframe
        testPage.pageHeader.shouldHave(text(string));
    }
    @Given("I switch to the frame {int}")
    public void ı_switch_to_the_frame(Integer int1) {
       // WebDriverRunner.getWebDriver().switchTo().frame(int1-1);
        switchTo().frame(int1-1);
    }
    @Given("I click on Back to TechProEducation.com")
    public void ı_click_on_back_to_tech_pro_education_com() {
        //inside the frame
    testPage.backToTechpro.click();
    }

}