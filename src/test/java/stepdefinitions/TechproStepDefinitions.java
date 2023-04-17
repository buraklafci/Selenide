package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.TestPage;

import static com.codeborne.selenide.Selenide.title;

public class TechproStepDefinitions {
    TestPage testPage=new TestPage();
    @Given("I get the title of tje current page and verify if it contain {string}")
    public void ı_get_the_title_of_tje_current_page_and_verify_if_it_contain(String string) {
       //getting the title of the page
       Assert.assertTrue(title().contains(string));
    }
    //    Screenshot of programs elements
    @Given("I capture the screenshot of the programs pop up")
    public void i_capture_the_screenshot_of_the_programs_pop_up() {
        try {
            testPage.upcomingPrograms.screenshot();
        }
        catch (Exception e) {

        }
    }
}
