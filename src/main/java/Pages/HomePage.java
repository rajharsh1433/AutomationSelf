package Pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Waits;
import utils.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;




public class HomePage {
	
	private WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	Waits wait = new Waits();
	private By  SignUpLoginBtn = By.cssSelector("a[href='/login']");
	private By  signupEmail = By.cssSelector("input[data-qa='signup-email']");
	private By  signupName = By.cssSelector("input[data-qa='signup-name']");
	private By  signuBtn = By.cssSelector("button[data-qa='signup-button']");
	private By loginEmail = By.cssSelector("input[data-qa='login-email']");
	private By  loginpassword = By.cssSelector("input[data-qa='login-password']");
	private By loginbutton = By.cssSelector("button[data-qa='login-button']");
	private By  SignupText = By.cssSelector("div[class='signup-form'] h2");
	private By  errorValidationText = By.xpath("//p[normalize-space()='Email Address already exist!']");
	private By  contactUspage = By.cssSelector("a[href='/contact_us']");
	private By productpage = By.cssSelector("a[href='/products']");
	private By subscriptiontext = By.xpath("//div[@class='single-widget']/h2");
	private By subsemail = By.id("susbscribe_email");
	private By subsbttn = By.xpath("//i[@class='fa fa-arrow-circle-o-right']");
	private By successtext = By.xpath("//div[@class='alert-success alert']");
	
	//private By verifcation = By.xpath("//li[10]//a[1]");
	
	//Navigates user to LoginSign up page
	public void LoginSignUp() {
		driver.findElement(SignUpLoginBtn).click();
	}
	
	//Enter the signup name
	public void enterSignUpName(String name) {
		driver.findElement(signupName).sendKeys(name);
	}
	
	//Enter the signup Email
	public void enterSignupEmail(String email) {
		driver.findElement(signupEmail).sendKeys(email);
	}
	
	//Click on the signup button
	public void clickSignUpBtn() {
		driver.findElement(signuBtn).click();
	}
	
	//user enters login email and passowrd
	public void enterlogindetails(String email,String password) {
		driver.findElement(loginEmail).sendKeys(email);
		driver.findElement(loginpassword).sendKeys(password);
		
	}
	//public void user clicks on login button
	public void clicksloginbutton() {
		driver.findElement(loginbutton).click();
	}
	//Verifying the login message
	public boolean verification(String username) {
        String text = wait.waitForVisibility(driver,By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b")).getText();
        if(username.equalsIgnoreCase(text)) {
        	return true;
        }
        return false;  
	}
	
	public boolean verifyNewuserSignup() {
		String text = driver.findElement(SignupText).getText();
		return "New User Signup!".equals(text.trim());
	}
	public boolean verifyErrorMessage() {
		String text = driver.findElement(errorValidationText).getText();
		return "Email Address already exist!".equals(text.trim());
	}
	public void ContactUsPageNavigation() {
		driver.findElement(contactUspage).click();
	}
	public void productPageNavigation() {
		driver.findElement(productpage).click(); 
	}
	public String subscriptiontextvalidation() {
		WebElement substext = driver.findElement(subscriptiontext);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//scrolling down to the page until the element is visible
		js.executeScript("arguments[0].scrollIntoView()", substext);
		String text = substext.getText();
		return text;
	}
	public void enterdetails(String email) {
		driver.findElement(subsemail).sendKeys(email);
		driver.findElement(subsbttn).click();
	}
	public String successmessage() {
		String text = driver.findElement(successtext).getText();
		return text;
	}
}
