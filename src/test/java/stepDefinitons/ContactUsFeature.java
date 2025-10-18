package stepDefinitons;

import org.testng.Assert;

import Pages.ContactUsPage;
import Pages.HomePage;
//import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WebDriverFactory;

public class ContactUsFeature {
	
	private HomePage homepage;
	private ContactUsPage contactpage;
	//private LoginFeature loginfeature;
	
	
	
	@When("the user clicks on \"Contact Us\"")
	public void user_clicks_contactus() {
		homepage = new HomePage(WebDriverFactory.getDriver());
		homepage.ContactUsPageNavigation();
		contactpage = new ContactUsPage(WebDriverFactory.getDriver());
	}
	
	@Then("the \"Get in touch\" section should be visible")
	public void validation_of_contactUspageNavigation() {
		String text = contactpage.validateText();
		Assert.assertTrue(text.equalsIgnoreCase("Get In Touch"));
	}
	@When("the user enters name,email, subject, and message")
	public void enter_the_details() {
		contactpage.enterDetails("Harsh Raj Singh", "testemail1234@gmail.com", "Testing Purpose", "Testing Purpose");
	}
	@When("the user uploads a file")
	public void file_upload() {
		contactpage.fileUpload("/Users/harshrajsingh/Documents/React Hooks.pdf");
	}
	@When("the user clicks on the submit button")
	public void user_clicks_submitbttn() {
		contactpage.ClickonSubmitbtn();
	}
	@When("the user clicks on the OK button in the alert")
	public void user_handles_alert_box() {
		contactpage.handlealerts();
	}
	@Then("the message \"Success! Your details have been submitted successfully.\" should be visible")
	public void success_mssg_validation() {
		String text = contactpage.successMessageValidation();
		Assert.assertTrue(text.equalsIgnoreCase("Success! Your details have been submitted successfully."));
	}
	

}
