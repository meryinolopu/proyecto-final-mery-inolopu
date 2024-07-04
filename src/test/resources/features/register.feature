#Author: 	Mery Inolopú
#Keywords Summary: Register

Feature: Register two new users on Juice Shop
  I want to register new users

  @Scenario1
	Scenario Outline: Successful register with valid information
	  Given user is on Register page "https://juice-shop.herokuapp.com/"
	  When user enters valid information to create new accounts
	  | test23@testing.com | Pass234$ | Pass234$ | Teresa |
	  | test22@testing.com | Pass234$ | Pass234$ | Susan |
	  Then user sees a confirmation message for each user
	  
