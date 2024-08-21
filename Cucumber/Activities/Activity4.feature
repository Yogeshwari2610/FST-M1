@activity4
Feature: Data driven without Example

@loginTest @loginSuccess
Scenario: Testing with Correct data frominputs
Given the user is on the login page
When the user enters "admin" and "password"
And clicks the submit button
Then get the confirmation text and verify message as "Welcome Back, Admin"