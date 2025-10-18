package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/features/",
	    glue = {"stepDefinitons", "Hook"},
	    plugin = {"pretty", "html:target/cucumber-html-report"},
	    monochrome = true
	)
public class LoginRunner extends AbstractTestNGCucumberTests{
	

}
