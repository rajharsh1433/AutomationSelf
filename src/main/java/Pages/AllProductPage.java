package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Waits;
import utils.WebDriverFactory;

public class AllProductPage {
	
	private WebDriver driver;
	
	
	public AllProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//initalizing the Waits class for utilizing the waits
	Waits wait = new Waits();
	
	//private By validationText = By.xpath("/");
	private By Allproductlist = By.xpath("//div[@class='product-image-wrapper']");
	private By searchinputtextArea = By.xpath("//input[@id='search_product']");
	private By searchbutton = By.xpath("//button[@id='submit_search']");
	private By modal = By.xpath("//div[@class='modal-content']");
	
	
	public String getValidationText() {
		 String text = wait.waitForVisibility(driver,By.xpath("//h2[@class='title text-center']")).getText();
		 return text;
	}
	
	public List<String> getAllProductsName(){
		List<String> productlist = driver.findElements(Allproductlist)
				.stream()
				.map(WebElement::getText)
				.toList();
		
		return productlist;
	}
	
	public Boolean productlistvalidation() {
		 List<String> listProducts = getAllProductsName();
		 return listProducts.size()>0;
	}
	
	public void clickFirstProductView() {
	    List<WebElement> products = wait.waitForAllVisible(driver,Allproductlist);
	    WebElement firstProductLink = products.get(0).findElement(By.linkText("View Product"));
	    ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("arguments[0].click();", firstProductLink);
	}
	
	public void hover_addToCart(int id) {
		List<WebElement> products = driver.findElements(Allproductlist);
		WebElement prc = products.get(id);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", prc);
		//Creating an Action Class for hover
		Actions action = new Actions(driver);
		action.moveToElement(prc).perform();
		//Now clicking on add to cart button
		WebElement addToCart = prc.findElement(By.xpath(".//div[@class='overlay-content']/a"));
		//Will click this only when its visible
		wait.waitForVisibility(driver,addToCart);
		addToCart.click();
	}
	
	public void continue_shoppingHandle() {
		WebElement Modal = driver.findElement(modal);
		wait.waitForVisibility(driver,Modal);
		//now once the modal is visible click on the button
		driver.findElement(By.xpath("//div[@class='modal-footer']/button")).click();
	}
	
	public void view_cart() {
		WebElement Modal = driver.findElement(modal);
		wait.waitForVisibility(driver,modal);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement viewCart = Modal.findElement(By.xpath("//div[@class='modal-body']//p[@class='text-center']//a[@href='/view_cart']"));
		viewCart.click();
	}
	
	public void search_product(String product_name) {
		driver.findElement(searchinputtextArea).sendKeys(product_name);
		driver.findElement(searchbutton).click();
	}
}