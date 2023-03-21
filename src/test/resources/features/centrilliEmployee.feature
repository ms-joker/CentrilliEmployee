Feature: centrilli Employee functionality
  Story: tests Employee functionalities of qa.centrilli.com as a tester

  Background: user logged in as posmanager

    Given user go to employee page

  Scenario: Create new employee
    When user click create button
    Then user should be able to create employee

  Scenario: Can cancel creating by clicking discard button
    When user click discard button
    Then user can cancel creating

  Scenario: Cannot create without typing name;
    When user click save without entering employee name
    Then user should not creating employee

  Scenario: Page title is new employee after created new employee
    When user click create button
    Then user should see title as New Employee

  Scenario: Can see Employee Created message
    When user click create button
    Then user can see Employee Created message at the bottom

  Scenario: Find new employee by using search box
    When user search the employee
    Then user can locate the new employee created by search

  Scenario: Display can be changed to Kanban
    When user click kanban icon
    Then user can see the table as kanban

  Scenario: Display can be changed to List
    When user click list icon
    Then user can see the table as list

    Scenario: all Employee number increased one
      When user click create button
      Then number of employees increased one