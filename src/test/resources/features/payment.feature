#Author: 	Mery Inolopú
#Keywords Summary: Payment

Feature: Register two new payment methods on Juice Shop
  I want to register new payment methods

  @Scenario5
	Scenario Outline: Successful add two payment methods with valid information
	  Given user is on Add New Card page "https://juice-shop.herokuapp.com/"
	  When user enters valid information to create new payment methods
	  | TestNameOne | 5425233430109903 |
	  | TestNameTwo | 4000000000001000 |
	  Then user sees a confirmation message for each payment method