Feature: Validate the reset functionality of FaceBook
@reset

Scenario: Validating with valid phone number.
When User input the valid phone number
And Click the search button 
Then Reset password page should open
@reset

Scenario: Validating with vaid Email.
When User input the valid Email id
And Click the search button 
Then Reset password page should open