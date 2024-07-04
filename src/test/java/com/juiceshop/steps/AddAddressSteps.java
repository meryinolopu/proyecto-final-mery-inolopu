package com.juiceshop.steps;

import java.util.List;

import org.openqa.selenium.By;

import com.juiceshop.utils.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddAddressSteps {
	
private Hooks hooks;
	
	public AddAddressSteps(Hooks hooks) {
		this.hooks=hooks;
	}
	
	@Given("user is on Add New Address page {string}")
	public void user_is_on_add_new_address_page(String url) throws InterruptedException{
		
		hooks.getDriver().get(url);
	    
	    if (hooks.getDriver().findElements(By.xpath(
				"*//button[@class='mat-focus-indicator close-dialog mat-raised-button mat-button-base mat-primary ng-star-inserted']")).size() != 0)
		{
	    	hooks.getDriver().findElement(By.xpath(
					"*//button[@class='mat-focus-indicator close-dialog mat-raised-button mat-button-base mat-primary ng-star-inserted']")).click();
		}
		
	    hooks.getDriver().findElement(By.id("navbarAccount")).click();
	    hooks.getDriver().findElement(By.id("navbarLoginButton")).click();
	    Thread.sleep(3000);
	    hooks.getDriver().findElement(By.id("email")).sendKeys("test22@testing.com");  
		hooks.getDriver().findElement(By.id("password")).sendKeys("Pass234$");
		hooks.getDriver().findElement(By.id("loginButton")).click();
	    hooks.getDriver().findElement(By.id("navbarAccount")).click();
	    hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Show Orders and Payment Menu']")).click();
	    hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Go to saved address page']")).click();
	    hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Add a new address']")).click();
	}

	@When("user enters valid information to create new addresses")
	public void user_enters_valid_information_to_create_new_addresses(io.cucumber.datatable.DataTable addAddress) throws InterruptedException{
		List<List<String>> multiAddAddress = addAddress.asLists();
		
		for (List<String> list : multiAddAddress) {
			
			hooks.getDriver().findElement(By.xpath("*//input[@placeholder='Please provide a country.']")).sendKeys(list.get(0));
			hooks.getDriver().findElement(By.xpath("*//input[@placeholder='Please provide a name.']")).sendKeys(list.get(1));
			hooks.getDriver().findElement(By.xpath("*//input[@placeholder='Please provide a mobile number.']")).sendKeys(list.get(2));
			hooks.getDriver().findElement(By.xpath("*//input[@placeholder='Please provide a ZIP code.']")).sendKeys(list.get(3));
			hooks.getDriver().findElement(By.id("address")).sendKeys(list.get(4));
			hooks.getDriver().findElement(By.xpath("*//input[@placeholder='Please provide a city.']")).sendKeys(list.get(5));
			Thread.sleep(6000);
			hooks.getDriver().findElement(By.xpath("*//button[@id='submitButton']")).click();
			
			hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Add a new address']")).click();
		}
	}

	@Then("user sees a confirmation message for each address")
	public void user_sees_a_confirmation_message_for_each_address() {
	   
	}
}

