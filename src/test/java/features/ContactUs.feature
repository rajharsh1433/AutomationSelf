Feature: Contact Us Page

  Scenario: Submit Contact Us Form Successfully
    Given the user is on the "automationExcerice.com" page
    When the user clicks on "Contact Us"
    Then the "Get in touch" section should be visible
    When the user enters email, subject, and message
    And the user uploads a file
    And the user clicks on the submit button
    And the user clicks on the OK button in the alert
    Then the message "Success! Your details have been submitted successfully." should be visible
