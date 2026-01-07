package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = "runner",
        plugin = {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
