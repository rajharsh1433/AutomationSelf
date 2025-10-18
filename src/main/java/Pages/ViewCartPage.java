package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.StringUtilityFnc;
import utils.Waits;
import utils.WebDriverFactory;

public class ViewCartPage {
	
	
	private WebDriver driver;
	
	public ViewCartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	StringUtilityFnc suf = new StringUtilityFnc(WebDriverFactory.getDriver()); 
    Waits wait = new Waits();
	
	//private By productlist = By.xpath(".//table[@id='cart_info_table']//tbody//tr");
	private By checkoutpage = By.linkText("Proceed To Checkout");
	private By  name = By.xpath("//ul[@id='address_delivery']//li[@class='address_firstname address_lastname']");
	private By  addr1 = By.xpath("//ul[@id='address_delivery']//li[@class='address_address1 address_address2']");
	private By  addr2 = By.xpath("//ul[@id='address_delivery']//li[@class='address_city address_state_name address_postcode']");
	private By addr3 = By.xpath("//ul[@id='address_delivery']//li[@class='address_country_name']");
	private By phone = By.xpath("//ul[@id='address_delivery']//li[@class='address_phone']");
	private By description = By.cssSelector("textarea[name='message']");
	private By orderPlacebtn = By.xpath("//a[@href='/payment']");
	private By namecardfield = By.xpath("//input[@name='name_on_card']");
	private By cardnumfield = By.xpath("//input[@name='card_number']");
	private By cvcfield = By.xpath("//input[@name='cvc']");
	private By expmonthfield = By.xpath("//input[@name='expiry_month']");
	private By expyearfield = By.xpath("//input[@name='expiry_year']");
	private By confirmorderbtn = By.xpath("//button[@id='submit']");
	private By ordercnfmssg = By.xpath("//h2[@data-qa='order-placed']//b");
	
	public List<String> getProductList(){
		    List<String> products = driver.findElements(By.xpath("//td[@class='cart_description']//h4/a"))
		                                  .stream()
		                                  .map(WebElement::getText)
		                                  .toList();
		    return products;
		}

	
	public boolean productValidation(String item1, String item2) {
		List<String> products = getProductList();
		int counter =0;
		
		
		for(String li:products) {
			System.out.println(li);
			if((li.equalsIgnoreCase(item1)) || (li.equalsIgnoreCase(item2))){
				counter++;
			}
		}
		if(counter!=2) {
			return false;
		}
		return true;
	}
	
	public void checkoutNavigation() {
		driver.findElement(checkoutpage).click();
	}
	
	//data validation function
	public boolean address_validation(String ename,String eaddr1,String eaddr2,String eaddr3,String citydetails,String ecountry,String mobile) {
		List<String> li = suf.getlist(addr1);
		String nme = driver.findElement(name).getText();
		String city_details = driver.findElement(addr2).getText();
		String country = driver.findElement(addr3).getText();
		String mobile_number = driver.findElement(phone).getText();
		
		//details validation
		if(ename.equalsIgnoreCase(nme) &&
		   li.contains(eaddr1) &&
		   li.contains(eaddr2) &&
		   li.contains(eaddr3) &&
		   citydetails.equalsIgnoreCase(city_details) &&
		   ecountry.equalsIgnoreCase(country) &&
		   mobile.equalsIgnoreCase(mobile_number)) {
			return true;
		}
		return false;
	}
	public void enterDescription(String text) {
		driver.findElement(description).sendKeys(text);
		driver.findElement(orderPlacebtn).click();
	}
	public void enterPaymentDetails(String name,String cardnumber,String cvc,String expmm,String expyyyy) {
		driver.findElement(namecardfield).sendKeys(name);
		driver.findElement(cardnumfield).sendKeys(cardnumber);
		driver.findElement(cvcfield).sendKeys(cvc);
		driver.findElement(expmonthfield).sendKeys(expmm);
		driver.findElement(expyearfield).sendKeys(expyyyy);
		WebElement subbtn = driver.findElement(confirmorderbtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subbtn);
		subbtn.click();
	}
	public Boolean messageVerification(String text) {
		//WebElement ordertxt = driver.findElement(ordercnfmssg);
		
		String actualtext = wait.waitForVisibility(driver,ordercnfmssg).getText();
		if(actualtext.equalsIgnoreCase(text)) {
			return true;
		}
		return false;
	}
}
