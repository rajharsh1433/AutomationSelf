package stepDefinitons;

import org.testng.Assert;

import Pages.AllProductPage;
import Pages.HomePage;
import Pages.ProductDetails;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WebDriverFactory;

public class ProductFeature {
	
	private HomePage homepage;
	private ProductDetails proddetail;
	private AllProductPage alp;
	
	@When("user clicks on Products button")
	public void user_clicks_products_bttn() {
		homepage = new  HomePage(WebDriverFactory.getDriver());
		homepage.productPageNavigation();
	}
	
	@Then("user is navigated to ALL products page")
	public void all_product_page_navigation() {
		alp = new AllProductPage(WebDriverFactory.getDriver());
	   String text = 	alp.getValidationText();
	   Assert.assertTrue(text.equalsIgnoreCase("All Products"));
	}
	@When("product list is visible")
	public void all_product_list_visibility() {
		Assert.assertTrue(alp.productlistvalidation());
	}
	@When("user clicks on view product of first product")
	public void user_clicks_on_viewProducts() {
		alp.clickFirstProductView();
	}
	@Then("user is landed to product details page")
	public void user_lands_on_productdetailspgage() {
		proddetail = new ProductDetails(WebDriverFactory.getDriver());
		String text = proddetail.getValidationText();
		Assert.assertTrue(text.equalsIgnoreCase("Write Your Review"));
	}
	@When("product details is visible: name,category,price,availability,condition,brand")
	public void product_details_validation() {
		Assert.assertTrue(proddetail.productDetails("Blue Top", "Category: Women > Tops", "Availability: In Stock", "Condition: New"));
	}
	@When("user enters product name in search and click on search button")
	public void product_search_feature() {
		alp.search_product("Blue top");
	}
	@Then("search products is visible")
	public void search_product_validation() {
		Assert.assertTrue(alp.productlistvalidation());
	}

}
