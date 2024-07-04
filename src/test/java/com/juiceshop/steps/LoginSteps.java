package com.juiceshop.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.juiceshop.utils.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps{
	
	private Hooks hooks;
	
	public LoginSteps(Hooks _hooks) {
		this.hooks=_hooks;
	}
	
	@Given("user is on Home page {string}")
	public void user_is_on_home_page(String url) {
	    hooks.getDriver().get(url);
	}

	@When("user navigate to Login page")
	public void user_navigate_to_login_page() {
		if (hooks.getDriver().findElements(By.xpath(
				"*//button[@class='mat-focus-indicator close-dialog mat-raised-button mat-button-base mat-primary ng-star-inserted']")).size() != 0)
		{
			hooks.getDriver().findElement(By.xpath(
					"*//button[@class='mat-focus-indicator close-dialog mat-raised-button mat-button-base mat-primary ng-star-inserted']")).click();
		}
		
		hooks.getDriver().findElement(By.id("navbarAccount")).click();
		hooks.getDriver().findElement(By.id("navbarLoginButton")).click();
	}
	
	/**Scenario2**/

	@When("user enters valid credentials")
	public void user_enters_valid_credentials() {
		hooks.getDriver().findElement(By.id("email")).sendKeys("test22@testing.com");  
		hooks.getDriver().findElement(By.id("password")).sendKeys("Pass234$"); 
		hooks.getDriver().findElement(By.id("loginButton")).click();
	}

	@Then("user can see his account")
	public void user_can_see_his_account() {
		String expected_title = "Your Basket";
		
		WebElement labelAccount = new WebDriverWait(hooks.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("*//span[@class='mat-button-wrapper']/span[.=' Your Basket']")));
        Assert.assertEquals(labelAccount.getText(),expected_title);
        
	}
	
	@After
	public void takeScreen(Scenario scenario) {
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot)hooks.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
			}
	}
	
	
	/**Scenario3**/
	
	@When("user enters invalid credentials")
	public void user_enters_invalid_credentials() {
		hooks.getDriver().findElement(By.id("email")).sendKeys("test200@testing.com");  
		hooks.getDriver().findElement(By.id("password")).sendKeys("Pass222$"); 
		hooks.getDriver().findElement(By.id("loginButton")).click();
	}

	@Then("user sees the validation message")
	public void user_sees_the_validation_message() {
		String expected_title = "Invalid email or password.";
		
		WebElement labelAccount = new WebDriverWait(hooks.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("*//div[@class='error ng-star-inserted']")));
        Assert.assertEquals(labelAccount.getText(),expected_title);
	}

}
