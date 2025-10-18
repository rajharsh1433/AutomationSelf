package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductDetails {
	
	private WebDriver driver;
	
	public ProductDetails(WebDriver driver) {
		this.driver = driver;
	}
	
	private By validationText = By.xpath("//li[@class='active']//a[@href='#reviews']");
	private By productname = By.xpath("//div[@class='product-information']//h2");
	private By category = By.xpath("//div[@class='product-details']//p[1]");
	private By availibility = By.xpath("//div[@class='product-details']//p[2]");
	private By condition = By.xpath("//div[@class='product-details']//p[3]"); 
	
	
	
	public String getValidationText() {
		return driver.findElement(validationText).getText();
	}
	
	public Boolean productDetails(String name,String dcategory,String davailability,String dcondition) {
		String pname = driver.findElement(productname).getText();
		String pcategory = driver.findElement(category).getText();
		String pavailibility = driver.findElement(availibility).getText();
		String pcondition = driver.findElement(condition).getText();
		
		System.out.println(pname);
		System.out.println(pcategory);
		System.out.println(pavailibility);
		System.out.println(pcondition);
		
		return (pname.equalsIgnoreCase(name)) && (pcategory.equalsIgnoreCase(dcategory)) && (pavailibility.equalsIgnoreCase(davailability))
				&& (pcondition.equalsIgnoreCase(pcondition));
	}
}
