Feature: CartFunctionality

Background:
    Given user is on automationexercise.com page
    
    
    Scenario: Add Products in Cart
    When user clicks on products button on HomePage
    And user hover over ith product and click on Add to cart
    Then clicks on continue shopping button
    And the user clicks on add to cart button for the i+1th product
    Then user clicks on view cart button
    And user verifies that both the product are added to the cart
    
    
    Scenario: Place order: Login before checkout
    When user clicks on loginsignup button
    And enters email,password, and clcik on login button
    And user is logged in and username is visisle
    Then user adds product to cart
    Then user clicks on view cart button
    And user clicks on proceed to checkout
    Then user verifies the address and review their order
    And Enter description in the text area and click on place order
    Then  user enters payment details and clicks on confirm button
    Then user verifes your order placement message
    
    
   