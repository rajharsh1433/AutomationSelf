package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/features/ContactUs.feature",
	    glue = {"stepDefinitons", "Hook"},
	    plugin = {"pretty", "html:target/cucumber-html-report"},
	    monochrome = true
	)
public class ContactUsRunner extends AbstractTestNGCucumberTests {
   
}
