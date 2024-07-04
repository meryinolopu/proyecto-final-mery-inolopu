#Author: 	Mery Inolopú
#Keywords Summary: OrderHistory

Feature: Review order history on Juice Shop
	I want to review my order history

	@Scenario8
	Scenario: Review my order history 
	  Given user is on Home page to review the orders "https://juice-shop.herokuapp.com/"
	  When user sees the two orders
	  Then user takes a screenshot of the orders