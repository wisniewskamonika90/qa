Feature: User panel

    Background:
      Given User starts on main page
      When User logs to the panel
      Then User can modify user profile

    @wordpress @login @userprofile
    Scenario: User login