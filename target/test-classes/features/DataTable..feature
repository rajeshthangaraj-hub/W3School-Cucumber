Feature: Search a tutorial

Scenario Outline: User search a tutorial from home page

Given user is on home page
When user click on search box and type "<tutorial>"
And select "<result>" from the recommended search dropdown
Then user should land on "<tutorial>" "<result>" tutorial page 

Examples:
|tutorial | result |
|python		| lists |
|python   | arrays |