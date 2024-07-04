#Author: 	Mery Inolopú
#Keywords Summary: Cart

Feature: Buy products on Juice Shop
	I want to buy products

	@Scenario6
	Scenario: Buy three products
	  Given user is on Home page to add mandatory products "https://juice-shop.herokuapp.com/"
	  When user adds three products to the cart
	  And user does the chekout of the three products
	  Then user sees a confirmation message of the first purchase

	@Scenario7
	Scenario: Buy two products
	  Given user is on Home page to add random products "https://juice-shop.herokuapp.com/"
	  When user adds two products to the cart
	  And user does the chekout of the two products
	  Then user sees a confirmation message of the second purchase
