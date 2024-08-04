Feature: Validate the Editor page

Background:
Given user is on home page
When user click on search box and type "python"
When select "lists" from the recommended search dropdown
Then user should land on "python" "lists" tutorial page
When user click on Try it Yourself
Then user should land on "W3Schools Tryit Editor" page

Scenario: Validate the editor result

Then validate the result in output

Scenario: Validate the Theme

When user click on change theme
Then editor page should turn dark
When user click on change theme
Then editor page should turn light

