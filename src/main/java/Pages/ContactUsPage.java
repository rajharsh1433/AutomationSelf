package Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Waits;
import utils.WebDriverFactory;

public class ContactUsPage {
	
	private WebDriver driver;
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	Waits wait = new Waits();
	
	//private By validationText = By.cssSelector("div[class='contact-form'] h2");
	private By name = By.cssSelector("input[data-qa='name']");
	private By email = By.cssSelector("input[data-qa='email']");
	private By Subject = By.cssSelector("input[data-qa='subject']");
	private By message = By.cssSelector("textarea[data-qa='message']");
	private By fileupload = By.cssSelector("input[name='upload_file']");
	private By Submitbtn = By.cssSelector("input[data-qa='submit-button']");
	private By successmssg = By.cssSelector("div[class='status alert alert-success']");
	
	public String validateText() {
		 String text = wait.waitForVisibility(driver,By.cssSelector("div[class='contact-form'] h2")).getText();
		 return text;
	}
	public void enterDetails(String ename,String eemail,String eSubject,String emessage) {
		driver.findElement(name).sendKeys(ename);
		driver.findElement(email).sendKeys(eemail);
		driver.findElement(Subject).sendKeys(eSubject);
		driver.findElement(message).sendKeys(emessage);
	}
	public void fileUpload(String path) {
		driver.findElement(fileupload).sendKeys(path);
	}
	public void ClickonSubmitbtn() {
		driver.findElement(Submitbtn).click();
	}
	public void handlealerts() {
		Alert alert = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}
	public String successMessageValidation() {
		String text = driver.findElement(successmssg).getText();
		return text;
	}

}
