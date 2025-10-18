package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/features/Cart.feature",
	    glue = {"stepDefinitons", "Hook"},
	    plugin = {"pretty", "html:target/cucumber-html-report"},
	    monochrome = true
	)
public class CartRunner extends AbstractTestNGCucumberTests{

}
