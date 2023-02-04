Feature: Validate the login functionality of FaceBook
@Login
Scenario: Validating with Invalid username and password
When Input the invalid username and password in their respective fields
And Click the Login button
Then Invaid login credentials page should open

@Login
Scenario: Validating with Invalid username and vaid password
When Input the invalid username and valid password in their respective fields
And Click the Login button
Then Invaid login credentials page should open

@Login
Scenario: Validating with valid username and invalid password
When Input the valid username and invalid password in their respective fields
And Click the Login button
Then Invaid login credentials page should open