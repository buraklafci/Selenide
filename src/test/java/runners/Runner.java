package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target\\cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},
        features = "C:\\Users\\burak\\IdeaProjects\\my-selenide-project",
        glue = "stepdefinitions",
        tags = "@screenshot_page",
        dryRun = false

)

public class Runner {
}