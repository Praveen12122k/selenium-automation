package TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/features/Login.feature"},
        glue = {"stepdefinitions"},
        plugin = {"pretty","html:target/HTMLReport.html"}
)
public class BDDrunner extends AbstractTestNGCucumberTests{
}
