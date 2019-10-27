package ozon;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/ozon/features",
        glue = "ozon",
        tags = "@all",
        junit = "--step-notifications"
)
public class TestRunner {

}
