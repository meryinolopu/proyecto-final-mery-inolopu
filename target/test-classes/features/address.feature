#Author: 	Mery Inolopú
#Keywords Summary: Address

Feature: Register two new addresses on Juice Shop
  I want to register new addresses

  @Scenario4
	Scenario Outline: Successful add two addresses with valid information
	  Given user is on Add New Address page "https://juice-shop.herokuapp.com/"
	  When user enters valid information to create new addresses
	  | TestCountryOne | TestNameOne | 12121211 | 11111 | TestAddress 1 | CityOne |
	  | TestCountryTwo | TestNameTwo | 12121212 | 11112 | TestAddress 2 | CityTwo |
	  Then user sees a confirmation message for each address
