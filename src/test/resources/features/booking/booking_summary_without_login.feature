@TestTag
Feature: Booking Summary section

Scenario: All details are shown in booking summary section
    Given Vindhiyan is making the reservation in make my trip
    When he click on Hotels in the top menu bar
    And he select location as "Chennai, India"
    And he select date from "2020-06-16" to "2020-06-18"
    And he add "2" Adult and "2" kids for room one
    And he add "2" Adult and "2" kids for room two
    And he select travel type as "Leisure"
    And he click Search
    And he sets minimum value as 1000 in a slider
    And he selects user rating as "4 & above (Very Good)"
    And he clicks on hotel listed in 5 th position
    And he scrolls to the room type
    And he clicks select room on the first listed
    And he fills all the information
    And he selects smoking room and airport transfer in commonly requested
    And he unchecks for donation
    And he click Pay Now
    Then he checks details listed in booking summary