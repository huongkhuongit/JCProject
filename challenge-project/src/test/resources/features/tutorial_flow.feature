Feature: Login and Navigate

  Scenario: User logs in and navigates to tutorials
    Given the user logs in with username "auto_244332" and password "Testing1!"
    When the user opens the profile screen
    And the user taps on Tutorials
    Then the user should see sections:
      | Assigned Route |
      | Direct Booking |
      | Ticket Booking |
    And the user taps on Assigned Route
    And the tutorial button should be displayed
