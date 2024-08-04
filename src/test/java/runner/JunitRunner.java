package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features/Certificate.feature",
				glue ="stepDefinitions",
				monochrome = true ,
				plugin = {"pretty"})
public class JunitRunner {

}

//,"html:target/cucumber.html",
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
