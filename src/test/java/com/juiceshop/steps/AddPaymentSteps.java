package com.juiceshop.steps;

import java.util.List;

import org.openqa.selenium.By;

import com.juiceshop.utils.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddPaymentSteps {
	
private Hooks hooks;
	
	public AddPaymentSteps(Hooks hooks) {
		this.hooks=hooks;
	}
	
	
	@Given("user is on Add New Card page {string}")
	public void user_is_on_add_new_card_page(String url) throws InterruptedException {
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
	    hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Go to saved payment methods page']")).click();
	    hooks.getDriver().findElement(By.xpath("*//mat-expansion-panel-header[@aria-controls='cdk-accordion-child-0']")).click();
	}

	@When("user enters valid information to create new payment methods")
	public void user_enters_valid_information_to_create_new_payment_methods(io.cucumber.datatable.DataTable addPaymentMethods) throws InterruptedException{
		List<List<String>> multiAddPaymentMethods = addPaymentMethods.asLists();
		Thread.sleep(2000);
		
		if (hooks.getDriver().findElements(By.xpath(
				"*//a[@class='cc-btn cc-dismiss']")).size() != 0)
		{
			System.out.print("elemento encontrado");
			hooks.getDriver().findElement(By.xpath(
					"*//a[@class='cc-btn cc-dismiss']")).click();
		}
		
		for (List<String> list : multiAddPaymentMethods) {
			hooks.getDriver().findElement(By.xpath("*//input[@id='mat-input-3']")).sendKeys(list.get(0));
			hooks.getDriver().findElement(By.xpath("*//input[@id='mat-input-4']")).sendKeys(list.get(1));
			hooks.getDriver().findElement(By.xpath("*//select[@id='mat-input-5']")).click();
			hooks.getDriver().findElement(By.xpath("*//option[@class='ng-star-inserted'][.=1]")).click();
			Thread.sleep(3000);
			hooks.getDriver().findElement(By.xpath("*//select[@id='mat-input-6']")).click();
			hooks.getDriver().findElement(By.xpath("*//option[@class='ng-star-inserted'][.=2080]")).click();
			Thread.sleep(3000);
			
			hooks.getDriver().findElement(By.xpath("*//button[@id='submitButton']")).click();
			Thread.sleep(3000);
		}
	}

	@Then("user sees a confirmation message for each payment method")
	public void user_sees_a_confirmation_message_for_each_payment_method() {
	    
	}

}
