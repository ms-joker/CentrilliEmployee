Feature: centrilli Employee functionality
  Story: tests Employee functionalities of qa.centrilli.com as a tester

  Scenario: Create new employee
    Given user logged in as posmanager
    When user in employee page
    Then user should be able to create employee

  #Scenario: Cannot create without typing name;
  #  Then user should not creating employee without typing name

 # Scenario: Can cancel creating by clicking discard button
  #  Then user click Discard button to cancel

# Scenario: Page title is new employee after created new employee
#    Then user should see title as New Employee

#  Scenario: Can see Employee Created message
  #  Then user can see Employee Created message at the bottom

  #Scenario: Find new employee by using search box
  #  Then user can locate the new employee created

  #Scenario: Display can be changed between Kanban and List
  #  Then user can change the display
