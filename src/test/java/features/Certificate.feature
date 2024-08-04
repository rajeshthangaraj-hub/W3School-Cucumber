Feature: Certificate functionality

Background: 

Given user is on home page
When user click on Certificate menu

#Scenario: verify java and python certification
#
#When Click on "Php" Certificate
#Then user should land on "Java Certification Exam — W3Schools.com" page
#When user switch back to home page
#And Click on "Python" Certificate
#Then user should land on "Python Certification Exam — W3Schools.com" page

Scenario: Buy a Data Analytics Certification

When Click on "Data Analytics" Certificate
Then user should land on "Learn Data Analytics — W3Schools.com" page
When click on payment plans under purchase options
And choose "3 months, $70/ month" plan
And click on buy now button
Then user should navigate to "Your Shopping Cart — W3Schools.com" page
And click on paypal button  

