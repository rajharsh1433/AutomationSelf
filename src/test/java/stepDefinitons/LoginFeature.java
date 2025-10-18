package stepDefinitons;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.AccountRegistration;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WebDriverFactory;

public class LoginFeature {

    private HomePage homepage;
    private AccountRegistration accreg;
    


    @When("user clicks on SignupLogin button")
    public void user_clicks_on_signup_login_button() {
    	homepage = new HomePage(WebDriverFactory.getDriver());
        homepage.LoginSignUp();
        
    }

    @Then("user lands on SignupLogin joint page")
    public void user_lands_on_signup_login_joint_page() {
        String text = WebDriverFactory.getDriver()
            .findElement(By.cssSelector("div.signup-form h2")).getText();
        Assert.assertEquals(text.trim(), "New User Signup!");
    }

    @When("user enters name and email")
    public void user_enters_name_and_email() {
        homepage.enterSignUpName("Harsh Raj Singh");
        homepage.enterSignupEmail("rajharsh1466831@gmail.com");
    }

    @When("clicks on Signup button")
    public void clicks_on_signup_button() {
        homepage.clickSignUpBtn();
    }

    @Then("user lands on Enter Account Information page")
    public void user_lands_on_enter_account_information_page() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(10));
        String text = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//b[normalize-space()='Enter Account Information']")
            )
        ).getText();
        Assert.assertEquals(text.trim(), "ENTER ACCOUNT INFORMATION");
    }

    @Given("user is on Account registration page")
    public void user_is_on_AccountRegistrationPage() {
        //user_is_on_automationexercise_com_page();
        user_clicks_on_signup_login_button();
        user_lands_on_signup_login_joint_page();
        user_enters_name_and_email();
        clicks_on_signup_button();
        user_lands_on_enter_account_information_page();
        accreg = new AccountRegistration(WebDriverFactory.getDriver());
    }

    @When("user fills details title,name,email,password")
    public void user_enters_personal_information() {
        accreg.EnterPersonalInformation("Mr", "India1234");
    }

    @When("user enters date of birth")
    public void enter_dob() {
        accreg.EnterDoB("3", "December", "1998");
    }

    @When("Select Checkbox Signup for Newsletter")
    public void Newsletter() {
        accreg.SelectNewsletter();
    }

    @When("Select checkbox Receive Special offers from our Partners")
    public void OptionSelect() {
        accreg.Selectoptin();
    }

    @When("the user fills the address details")
    public void enter_address_details() {
        accreg.AddressDetails("Harsh", "Raj", "DUMMY", "ABCD", "EFGE", "India", "Haryana", "Guragaon", "122505", "987587565");
    }

    @When("the user clicks on create account button")
    public void click_on_createButton() {
        accreg.ClickCreateBtn();
    }

    @Then("Account Created should be visible")
    public void Account_created() {
        accreg.AccountCreated();
    }
    @When("user is on login page")
    public void user_on_loginpage() {
    	user_clicks_on_signup_login_button();
    }
    @Then("user enters correct email and password")
    public void user_enter_loginDetails() {
    	homepage.enterlogindetails("rajharsh1466831@gmail.com", "India1234");
    }
    @When("clicks on Login button")
    public void user_clicks_loginbttn() {
    	homepage.clicksloginbutton();
    }
    @Then("user gets Logged in as username message")
    public void login_message_verification() {
    	homepage.verification("Harsh Raj Singh");
    }
    
   
    @Then("New user signup is visible")
    public void new_user_signup_visibility() {
    	Assert.assertTrue(homepage.verifyNewuserSignup());
    }
    
    @Then("error Email Already Exists is visible")
    public void error_messsage_validation() {
    	Assert.assertTrue(homepage.verifyErrorMessage());
    }
    
    @When("user scrolls down to footer, susbcription text is visible")
    public void subsrciption_validation() {
    	homepage = new HomePage(WebDriverFactory.getDriver());
    	String text = homepage.subscriptiontextvalidation();
    	Assert.assertTrue(text.equalsIgnoreCase("Subscription"));
    }
    @When("user enters email id and click arrow button")
    public void enters_email_clicksbttn() {
    	homepage.enterdetails("raj76464@gmail.com");
    }
    @Then("success messge you have been successfully subscribed is visible")
    public void success_mssg_validation() {
    	String text = homepage.successmessage();
    	Assert.assertTrue(text.equalsIgnoreCase("You have been successfully subscribed!"));
    }
}
