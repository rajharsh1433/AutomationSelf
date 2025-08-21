Feature: Login/SignUp page

  Background:
    Given user is on automationexercise.com page

  Scenario: Successful Navigation to SignUp page
    When user clicks on SignupLogin button
    Then user lands on SignupLogin joint page
    When user enters name and email
    And clicks on Signup button
    Then user lands on Enter Account Information page
    
    
   Scenario: Successful User Registration
   	 Given user is on Account registration page
     When user fills details title,name,email,password
     And user enters date of birth
     And Select Checkbox Signup for Newsletter
     And Select checkbox Receive Special offers from our Partners
     And the user fills the address details
     And the user clicks on create account button
     Then Account Created should be visible
     
     
    Scenario: Login user with correct email and password
       When user is on login page
       Then user enters correct email and password
       And clicks on Login button
       Then user gets Logged in as username message
       
    Scenario: Registration using existing email
    	When user clicks on SignupLogin button
    	Then New user signup is visible
    	When user enters name and email
    	And clicks on Signup button
    	Then error Email Already Exists is visible
       
       
