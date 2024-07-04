package com.juiceshop.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks{
	
	public static int TIME_OUT = 10;
	
	
	protected WebDriver driver;
	
	@Before
	public void setup() {
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--clear-cache");
        options.addArguments("--incognito");
        
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
		driver.manage().window().maximize();
	}
	
	@After
	public void teardown() {
		//driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
