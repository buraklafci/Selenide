package stepdefinitions;

import com.codeborne.selenide.Configuration;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.std.DateSerializer;
import io.cucumber.java.en.*;


import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

import static com.codeborne.selenide.Selenide.screenshot;


public class CommonStepDefinitions {
    @Given("I set Configuration.screenshot to false")
    public void ı_set_configuration_screenshot_to_false() {
    //   will not take the screenshot even if the test case fails
        Configuration.screenshots=false;
    }

    //Screenshot
    @And("I capture the screenshot of the page")
    public void ıCaptureTheScreenshotOfThePage() {
        //        Selenide.screenshot("my_screenshot");//OR SIMPLY
        screenshot(String.valueOf(new Date().getTime()));//giving a dynamic name
    }

    @Given("I open the {string} browser")
    public void ıOpenTheBrowser(String browser) {
        switch (browser){
            case "headless":
                Configuration.headless=true;
                break;
            case "firefox":
                Configuration.browser="firefox";
                break;
            case "edge":
                Configuration.browser="edge";
                break;
            default://yazilmasa da default olarak chrome calisir
                Configuration.browser=browser;
                break;
        }
    }
}
