package bdd.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/bdd/features", glue = "bdd.stepDefinitions",
        // tags = "@DeletePlace"
        plugin = "json:target/jsonReports/cucumber-report.json" // Related to inputDirectory of plugin
                                                                // maven-surefire-plugin
)
public class TestRunner {

}
