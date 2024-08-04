Feature: Search a tutorial

Background:
Given user is on home page
When user click on search box and type "python"

Scenario: User search a tutorial from home page

When select "lists" from the recommended search dropdown
Then user should land on "python" "lists" tutorial page


Scenario: User run in editor page

When select "lists" from the recommended search dropdown
Then user should land on "python" "lists" tutorial page
When user click on Try it Yourself
Then user should land on "W3Schools Tryit Editor" page




