package com.juiceshop.steps;

import java.util.List;

import org.openqa.selenium.By;

import com.juiceshop.utils.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RegisterSteps {
	
	private Hooks hooks;
	
	public RegisterSteps(Hooks hooks) {
		this.hooks=hooks;
	}
	
	@Given("user is on Register page {string}")
	public void user_is_on_register_page(String url) throws InterruptedException {
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
	    hooks.getDriver().findElement(By.xpath("*//a[@class='primary-link']")).click();
	}
	
	
	@When("user enters valid information to create new accounts")
	public void user_enters_valid_information_to_create_new_accounts(io.cucumber.datatable.DataTable register) throws InterruptedException{
		
		List<List<String>> multiRegister = register.asLists();
		
		if (hooks.getDriver().findElements(By.xpath(
				"*//a[@class='cc-btn cc-dismiss']")).size() != 0)
		{
			System.out.print("elemento encontrado");
			hooks.getDriver().findElement(By.xpath(
					"*//a[@class='cc-btn cc-dismiss']")).click();
		}
		
		for (List<String> list : multiRegister) {
			
			hooks.getDriver().findElement(By.id("emailControl")).sendKeys(list.get(0));
			hooks.getDriver().findElement(By.id("passwordControl")).sendKeys(list.get(1));
			hooks.getDriver().findElement(By.id("repeatPasswordControl")).sendKeys(list.get(2));
			Thread.sleep(2000);
			hooks.getDriver().findElement(By.xpath("*//mat-select[@name='securityQuestion']")).click();
			Thread.sleep(2000);
			hooks.getDriver().findElement(By.xpath("*//mat-option[1]")).click();
			hooks.getDriver().findElement(By.id("securityAnswerControl")).sendKeys(list.get(3));
			hooks.getDriver().findElement(By.id("registerButton")).click();
			Thread.sleep(8000);
			hooks.getDriver().findElement(By.xpath("*//a[@class='primary-link']")).click();
		
		}
	}


	@Then("user sees a confirmation message for each user")
	public void user_sees_a_confirmation_message_for_each_user() {
		
		
	    
	}

}
