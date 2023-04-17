package stepdefinitions;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.*;

public class CommonStepDefinitions {
    @Given("I set Configuration.screenshot to false")
    public void ı_set_configuration_screenshot_to_false() {
//        will not take the screenshot even if the test case fails
        Configuration.screenshots=false;
    }
}
