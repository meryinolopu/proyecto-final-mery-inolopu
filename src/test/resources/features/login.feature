#Author: 	Mery Inolopú
#Keywords Summary: Login

Feature: Login on Juice Shop

	As a new user
	I want to login
	So that ...

	@Scenario2
	Scenario: Login with correct credentials
	  Given user is on Home page "https://juice-shop.herokuapp.com/"
	  When user navigate to Login page
	  And user enters valid credentials
	  Then user can see his account

	@Scenario3
	Scenario: Login with incorrect credentials
	  Given user is on Home page "https://juice-shop.herokuapp.com/"
	  When user navigate to Login page
	  And user enters invalid credentials
	  Then user sees the validation message

