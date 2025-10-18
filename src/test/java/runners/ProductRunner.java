package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/features/Product.feature",
	    glue = {"stepDefinitons", "Hook"},
	    plugin = {"pretty", "html:target/cucumber-html-report"},
	    monochrome = true
	)
public class ProductRunner extends AbstractTestNGCucumberTests {
	   

}
