package stepDefinitons;



//import Pages.HomePage;
import io.cucumber.java.en.Given;
import utils.ExtentTestManager;
import utils.WebDriverFactory;

public class CommonSteps {
	
	
	@Given("user is on automationexercise.com page")
	    public void user_is_on_automationexercise_com_page() {
	        WebDriverFactory.getDriver().get("https://www.automationexercise.com/");
	        ExtentTestManager.getTest();
	        	        
	    }

}
