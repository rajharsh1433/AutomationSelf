Feature: Products

 Background:
    Given user is on automationexercise.com page
	
	

Scenario: Verify All products and product details page
    When user clicks on Products button
    Then user is navigated to ALL products page
    And product list is visible
    When user clicks on view product of first product
    Then user is landed to product details page
    And product details is visible: name,category,price,availability,condition,brand
    

Scenario: Search Product
	 When user clicks on Products button
	 Then user is navigated to ALL products page
	 And  user enters product name in search and click on search button
	 Then search products is visible
	 
	 
	 
	 
	 


    
    