package stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.GooglePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class GoogleStepDefinitions {
    GooglePage googlePage=new GooglePage();
    @Given("I navigate to {string}")
    public void ı_navigate_to(String string) {
        //open("https://www.google.com");
        open(string); //going to URL

    }
    @Given("I wait for {int} seconds")
    public void ı_wait_for_seconds(Integer int1) {
        sleep(int1*1000);//5seconds =5000 miliseconds
    }
    @Given("I navigate back")
    public void ı_navigate_back() {
          back();
     }
    @Given("I navigate forward")
    public void ı_navigate_forward() {
           forward();
    }
    @Given("I refresh the page")
    public void ı_refresh_the_page() {
          refresh();
    }
    @Then("I hold the browser open")
    public void ı_hold_the_browser_open() {
        Configuration.holdBrowserOpen=true;
        //Selenide'de otomatik browser kapanir,bu kod sayesinde browser'i acik tutar
    }
    @When("I search for {string}")
    public void ı_search_for(String string) {
       googlePage.searchBox.setValue(string).pressEnter();
    }
    @Then("verify page source contains {string}")
    public void verify_page_source_contains(String string) {
        //WebDriverRunner.url();//returns the url of the page
        String pageSource=WebDriverRunner.source(); //returns the page source
        System.out.println(pageSource);
        Assert.assertTrue(pageSource.contains(string));
    }
    @Then("verify the result should contain {string} keyword")
    public void verify_the_result_should_contain_keyword(String string) {

        Assert.assertTrue(googlePage.resultSection.toString().contains(string));//in selenium
        googlePage.resultSection.shouldHave(text(string));//Yaklaşık 677.000.000 sonuç bulundu (0,43 saniye)

        googlePage.resultSection.shouldBe(visible);//checks if resultSection element is visible on the page

        googlePage.resultSection.shouldNotHave(exactText("Yaklaşık 677.000.000 sonuç bulundu (0,43 saniye)"));//saniye degisiklik gosterebilir,exact text'i birebir olmasi gerekir

        googlePage.resultSection.shouldNotHave(text("Mercedes"));//negative test checking if the text does not have Mercedes
    }
    @Then("the first result in the page sections should contain {string}")
    public void the_first_result_in_the_page_sections_should_contain(String string) {
        googlePage.getAllSections.get(0).shouldHave(text(string));//checks if the first section contains Tesla
    }
}
