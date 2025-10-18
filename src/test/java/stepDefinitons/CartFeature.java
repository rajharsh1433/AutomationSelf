package stepDefinitons;

import org.testng.Assert;

import Pages.AllProductPage;
import Pages.HomePage;
import Pages.ViewCartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WebDriverFactory;

public class CartFeature {
	
	private HomePage homepage;
	private AllProductPage alp;
	private ViewCartPage vcp;
	
	public CartFeature() {
		homepage = new HomePage(WebDriverFactory.getDriver());
		alp = new AllProductPage(WebDriverFactory.getDriver());
		vcp = new ViewCartPage(WebDriverFactory.getDriver());
	}
	@When("user clicks on products button on HomePage")
	public void product_pages_navigation() {
	
		homepage.productPageNavigation();
	}
	@When("user hover over ith product and click on Add to cart")
	public void hover_over_product() {
		
		alp.hover_addToCart(0);
	}
	@Then("clicks on continue shopping button")
	public void user_clicks_continue_shopping() {
		alp.continue_shoppingHandle();
	}
	@When("the user clicks on add to cart button for the i+1th product")
	public void user_adds_second_product() {
		alp.hover_addToCart(1);
	}
	@Then("user clicks on view cart button")
	public void view_cart() {
		alp.view_cart();
	}
	@When("user verifies that both the product are added to the cart")
	public void productlistValidation() {
		
		Assert.assertTrue(vcp.productValidation("Blue Top", "Men Tshirt"));
	}
	@When("user clicks on loginsignup button")
	public void user_login_page() {
		homepage.LoginSignUp();
	}
	@When("enters email,password, and clcik on login button")
	public void login_method() {
		homepage.enterlogindetails("rajharsh1433@gmail.com", "India1234");
		homepage.clicksloginbutton();
	}
	@When("user is logged in and username is visisle")
	public void successful_login() {
		Boolean text = homepage.verification("Harsh Raj Singh");
		Assert.assertTrue(text);
	}
	@Then("user adds product to cart")
	public void add_product_to_cart() {
		alp.hover_addToCart(0);
	}
	
	@When("user clicks on proceed to checkout")
	public void navigate_to_checkoutpage() {
		vcp.checkoutNavigation();
	}
	@Then("user verifies the address and review their order")
	public void address_and_orderVerification() {
	boolean res = vcp.address_validation("Mr. Harsh Raj", "DUMMY", "ABCD", "EFGE", "Guragaon Haryana 122505", "India", "987587565");
	Assert.assertTrue(res);
	}
	@When("Enter description in the text area and click on place order")
	public void user_enters_description() {
		vcp.enterDescription("testing purpose.");
	}
	@Then("user enters payment details and clicks on confirm button")
	public void user_enters_paymentdescription() {
		vcp.enterPaymentDetails("Hars", "1234567", "456", "08", "2029");
	}
	@Then("user verifes your order placement message")
	public void order_placement_message() {
		Assert.assertTrue(vcp.messageVerification("Order Placed!"));
	}
	
	
	
}
