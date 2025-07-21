package StepDefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/java/Features"} ,glue={"StepDefs"},tags = "@SearchMobile",
		monochrome=true,plugin={"pretty","html:target/htmlReport.html"}
		)
public class TestRunnner {

}
