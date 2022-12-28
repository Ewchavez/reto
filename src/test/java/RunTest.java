import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/feature/petstoreWeb"},
        junit={"--step-notifications"},
        glue = {"definitions"},
        tags = {"@ActualizarPet"},
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json" }
        )
public class RunTest {

}
