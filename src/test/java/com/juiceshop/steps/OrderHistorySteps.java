package com.juiceshop.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.juiceshop.utils.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderHistorySteps {
	
	private Hooks hooks;
	
	public OrderHistorySteps(Hooks _hooks) {
		this.hooks=_hooks;
	}
	
	@Given("user is on Home page to review the orders {string}")
	public void user_is_on_home_page_to_review_the_orders(String url) throws InterruptedException {
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

	@When("user sees the two orders")
	public void user_sees_the_two_orders() throws InterruptedException {
		hooks.getDriver().findElement(By.id("navbarAccount")).click();
		hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Show Orders and Payment Menu']")).click();
	    hooks.getDriver().findElement(By.xpath("*//button[@aria-label='Go to order history page']")).click();
	    Thread.sleep(3000);
	}

	@Then("user takes a screenshot of the orders")
	public void user_takes_a_screenshot_of_the_orders() {
		List<WebElement> elements = hooks.getDriver().findElements(By.xpath("*//div[.='Total Price']"));
		int elements_qty = elements.size();
		Assert.assertNotEquals(elements_qty, 0);
		
	}
	
	@After
	public void takeScreen(Scenario orderHistory) {
		final byte[] screenshot = ((TakesScreenshot)hooks.getDriver()).getScreenshotAs(OutputType.BYTES);
		orderHistory.attach(screenshot, "image/png", orderHistory.getName());
	}
}

