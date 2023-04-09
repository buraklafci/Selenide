package stepdefinitions;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.*;

import static com.codeborne.selenide.Selenide.*;


public class GoogleStepDefinitions {
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
}
