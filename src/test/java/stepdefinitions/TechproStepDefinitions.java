package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.title;

public class TechproStepDefinitions {
    @Given("I get the title of tje current page and verify if it contain {string}")
    public void ı_get_the_title_of_tje_current_page_and_verify_if_it_contain(String string) {
       //getting the title of the page
       Assert.assertTrue(title().contains(string));
    }
}
