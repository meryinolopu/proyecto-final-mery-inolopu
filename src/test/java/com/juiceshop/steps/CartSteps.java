package com.juiceshop.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.juiceshop.utils.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {
	
private Hooks hooks;
	
	public CartSteps(Hooks _hooks) {
		this.hooks=_hooks;
	}
	
	/* Scenario 6 */
	
	@Given("user is on Home page to add mandatory products {string}")
	public void user_is_on_home_page_to_add_mandatory_products(String url) throws InterruptedException {
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
	}

	@When("user adds three products to the cart")
	public void user_adds_three_products_to_the_cart() throws InterruptedException {
		
		if (hooks.getDriver().findElements(By.xpath(
				"*//a[@class='cc-btn cc-dismiss']")).size() != 0)
		{
			System.out.print("elemento encontrado");
			hooks.getDriver().findElement(By.xpath(
					"*//a[@class='cc-btn cc-dismiss']")).click();
		}
		
		hooks.getDriver().findElement(By.id("searchQuery")).click(); 
		hooks.getDriver().findElement(By.id("mat-input-0")).sendKeys("apple");
		hooks.getDriver().findElement(By.id("mat-input-0")).sendKeys(Keys.ENTER);
		hooks.getDriver().findElement(By.xpath("*//span[@class='mat-button-wrapper']/span[.='Add to Basket']")).click();
		Thread.sleep(2000);
		hooks.getDriver().findElement(By.xpath("*//mat-icon[.=' close ']")).click();
		hooks.getDriver().findElement(By.xpath("*//mat-icon[.=' search ']")).click();
		Thread.sleep(1000);
		hooks.getDriver().findElement(By.id("mat-input-0")).sendKeys("banana");
		hooks.getDriver().findElement(By.id("mat-input-0")).sendKeys(Keys.ENTER);
		hooks.getDriver().findElement(By.xpath("*//span[@class='mat-button-wrapper']/span[.='Add to Basket']")).click();
		Thread.sleep(2000);
		hooks.getDriver().findElement(By.xpath("*//mat-icon[.=' close ']")).click();
		hooks.getDriver().findElement(By.xpath("*//mat-icon[.=' search ']")).click();
		Thread.sleep(1000);
		hooks.getDriver().findElement(By.id("mat-input-0")).sendKeys("t-shirt");
		hooks.getDriver().findElement(By.id("mat-input-0")).sendKeys(Keys.ENTER);
		hooks.getDriver().findElement(By.xpath("*//span[@class='mat-button-wrapper']/span[.='Add to Basket']")).click();
		Thread.sleep(3000);
	}

	@When("user does the chekout of the three products")
	public void user_does_the_chekout_of_the_three_products() throws InterruptedException {
		hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Show the shopping cart']")).click();
		Thread.sleep(3000);
		hooks.getDriver().findElement(By.id("checkoutButton")).click();
		Thread.sleep(1000);
		hooks.getDriver().findElement(By.xpath("*//mat-radio-button[@id='mat-radio-43']")).click();
		hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Proceed to payment selection']")).click();
		Thread.sleep(1000);
		hooks.getDriver().findElement(By.xpath("*//mat-radio-button[@id='mat-radio-44']")).click();
		hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Proceed to delivery method selection']")).click();
		Thread.sleep(1000);
		hooks.getDriver().findElement(By.xpath("*//mat-radio-button[@id='mat-radio-47']")).click();
		hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Proceed to review']")).click();
		Thread.sleep(1000);
		hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Complete your purchase']")).click();
	}

	@Then("user sees a confirmation message of the first purchase")
	public void user_sees_a_confirmation_message_of_the_first_purchase() {
		String expected_title = "Thank you for your purchase!";
		
		WebElement labelAccount = new WebDriverWait(hooks.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("*//h1[@class='confirmation']")));
        Assert.assertEquals(labelAccount.getText(),expected_title);
	    
	}
	
	/* Scenario 7 */
	
	@Given("user is on Home page to add random products {string}")
	public void user_is_on_home_page_to_add_random_products(String url) throws InterruptedException {
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
	}

	@When("user adds two products to the cart")
	public void user_adds_two_products_to_the_cart() throws InterruptedException {
		if (hooks.getDriver().findElements(By.xpath(
				"*//a[@class='cc-btn cc-dismiss']")).size() != 0)
		{
			System.out.print("elemento encontrado");
			hooks.getDriver().findElement(By.xpath(
					"*//a[@class='cc-btn cc-dismiss']")).click();
		}
		
		hooks.getDriver().findElement(By.id("searchQuery")).click(); 
		hooks.getDriver().findElement(By.id("mat-input-0")).sendKeys("carrot");
		hooks.getDriver().findElement(By.id("mat-input-0")).sendKeys(Keys.ENTER);
		hooks.getDriver().findElement(By.xpath("*//span[@class='mat-button-wrapper']/span[.='Add to Basket']")).click();
		Thread.sleep(2000);
		hooks.getDriver().findElement(By.xpath("*//mat-icon[.=' close ']")).click();
		hooks.getDriver().findElement(By.xpath("*//mat-icon[.=' search ']")).click();
		Thread.sleep(1000);
		hooks.getDriver().findElement(By.id("mat-input-0")).sendKeys("melon");
		hooks.getDriver().findElement(By.id("mat-input-0")).sendKeys(Keys.ENTER);
		hooks.getDriver().findElement(By.xpath("*//span[@class='mat-button-wrapper']/span[.='Add to Basket']")).click();
		Thread.sleep(3000);
	}

	@When("user does the chekout of the two products")
	public void user_does_the_chekout_of_the_two_products() throws InterruptedException {
		hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Show the shopping cart']")).click();
		Thread.sleep(3000);
		hooks.getDriver().findElement(By.id("checkoutButton")).click();
		Thread.sleep(2000);
		hooks.getDriver().findElement(By.xpath("*//mat-radio-button[@id='mat-radio-43']")).click();
		hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Proceed to payment selection']")).click();
		Thread.sleep(2000);
		hooks.getDriver().findElement(By.xpath("*//mat-radio-button[@id='mat-radio-44']")).click();
		hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Proceed to delivery method selection']")).click();
		Thread.sleep(2000);
		hooks.getDriver().findElement(By.xpath("*//mat-radio-button[@id='mat-radio-47']")).click();
		hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Proceed to review']")).click();
		Thread.sleep(1000);
		hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Complete your purchase']")).click();
	}

	@Then("user sees a confirmation message of the second purchase")
	public void user_sees_a_confirmation_message_of_the_second_purchase() {
		String expected_title = "Thank you for your purchase!";
		
		WebElement labelAccount = new WebDriverWait(hooks.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("*//h1[@class='confirmation']")));
        Assert.assertEquals(labelAccount.getText(),expected_title);    
	    
	}
	
}
