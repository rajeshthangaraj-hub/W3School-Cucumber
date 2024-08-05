Feature: Mouse validation

Background: 
Given user is on home page
And user click on search box and type "python"

#Scenario: Click on Try button using Mouse
#
#When select "lists" from the recommended search dropdown
#Then user should land on "python" "lists" tutorial page
#When user scroll to "Allow Duplicates" section
#And user click on Try it Yourself
#Then user should land on "W3Schools Tryit Editor" page

Scenario: Scroll to the Footer section and click on NEWSLETTER

When select "lists" from the recommended search dropdown
Then user should land on "python" "lists" tutorial page
When user scroll to "NEWSLETTER" section
And click on NEWSLETTER
Then user should land on "Newsletter — W3Schools.com" page
