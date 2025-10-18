Feature: Contact Us Page

 Background:
    Given user is on automationexercise.com page

  Scenario: Submit Contact Us Form Successfully
    When the user clicks on "Contact Us"
    Then the "Get in touch" section should be visible
    When the user enters name,email, subject, and message
    And the user uploads a file
    And the user clicks on the submit button
    And the user clicks on the OK button in the alert
    Then the message "Success! Your details have been submitted successfully." should be visible
