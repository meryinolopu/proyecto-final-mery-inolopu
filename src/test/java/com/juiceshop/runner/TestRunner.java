package com.juiceshop.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/features",
		glue={"com.juiceshop.steps","com.juiceshop.utils"},
		plugin= {"pretty","summary",
				"html:target/test-report.html",
				"json:target/cucumber.json",
				"junit:target/cucumber.xml"
				},
		monochrome = false,
		publish = true,
		tags = "@Scenario8",
		dryRun = false
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	
}
