package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features", glue = "steps",
        plugin = {"json:target/cucumber.json"}, tags = {"@Test"})
public class cucumberRunner {
}
