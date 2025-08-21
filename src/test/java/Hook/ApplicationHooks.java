package Hook;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.WebDriverFactory;


public class ApplicationHooks {
	
	 WebDriverFactory driverFactory = new WebDriverFactory();
	
	
	
	
	@Before
	public void setup() {
		driverFactory.initDriver("chrome");
	}
	
	@After
	public void tearDown() {
		driverFactory.quitDriver();
	}

}
