package bdd.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/bdd/features", 
    glue = "bdd.stepDefinitions")
public class TestRunner {

}
