package stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.TestPage;

import java.io.File;
import java.text.DateFormat;
import java.time.Duration;
import java.util.Date;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


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
    //Alert
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

    //Frame
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

    //Switch Window
    @Then("I switch  to window {int}")
    public void ı_switch_to_window(Integer int1) {
     switchTo().window(int1-1);
    }
    @Then("I get the URL of the page and verify it contains {string}")
    public void ı_get_the_url_of_the_page_and_verify_it_contains(String string) {
        Assert.assertTrue(WebDriverRunner.url().contains(string));

    }
    //Actions
    @When("I drag the source in the target")
    public void ıDragTheSourceInTheTarget() {
        //actions().dragAndDrop(testPage.source,testPage.target).build().perform();
        //actions().dragAndDropBy(testPage.source,305,167).perform();
        actions().clickAndHold(testPage.source).moveToElement(testPage.target).perform();

    }

    @And("I scroll the page down")
    public void ıScrollThePageDown() {
       actions().sendKeys(Keys.PAGE_DOWN).perform();
        //a little bit
        actions().sendKeys(Keys.ARROW_DOWN).build().perform();
    }

    //Explicit Wait
    @And("I click on start button")
    public void ıClickOnStartButton() {
        testPage.startButton.click();
    }

    @Then("verify the Hello World! text is displayed")
    public void verifyTheHelloWorldTextIsDisplayed() {
  //      FAILS WITH NO WAIT
//        System.out.println("TEXT =>>> "+testPage.resultExplicitWait.getText());// Hello World!
//        Assert.assertEquals("Hello World!",testPage.resultExplicitWait.getText());//FAIL

//        TO FIX THE ISSUE THE BEST OPTION IS EXPLICIT WAIT BECAUSE IT IS DYNAMIC
//        1. Handle with WebDriverWait class
//        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOf(testPage.resultExplicitWait));
//        Assert.assertEquals("Hello World!",testPage.resultExplicitWait.getText());//PASS


//        2. selenide wait
//        testPage.helloWorld.should(visible,Duration.ofSeconds(20)); //OR
        testPage.resultExplicitWait.should(visible,Duration.ofSeconds(20));
        Assert.assertEquals("Hello World!",testPage.resultExplicitWait.getText());


    }
    //file upload
    @And("I try to upload the file on this path {string}")
    public void ıTryToUploadTheFileOnThisPath(String str) {
      //        Getting the file path
     //                            USER DIRECTORY + FILE PATH = FULL PATH
        String path=System.getProperty("user.home")+str;
        System.out.println(path);
        File fullPath=new File(path);
        //        Selecting the file
        testPage.chooseFile.uploadFile(fullPath);
        //        click upload button
        testPage.upload.click();

    }

    @Then("I verify the file is uploaded")
    public void ıVerifyTheFileIsUploaded() {
        testPage.resultFileUpload.shouldHave(text("File Uploaded!"));
    }

    //jsexecutor
    @And("I scroll down to footer section by js")
    public void ıScrollDownToFooterSectionByJs() {
       // Selenide.executeJavaScript();
        SelenideElement footerElement=$(By.xpath("//table[@class='navFooterMoreOnAmazon']"));
        executeJavaScript("arguments[0].scrollIntoView();",footerElement);
    }

    @And("I click on {string} by js on amazon table")
    public void ıClickOnByJsOnAmazonTable(String str) {
        SelenideElement element=$(By.xpath("//table[@class='navFooterMoreOnAmazon']//*[contains(text(),'"+str+"')]"));
        executeJavaScript("arguments[0].click();",element);

        //Alternatively locating the element with js
       // executeJavaScript("document.getElementById('icp-nav-flyout').click();");
    }
}