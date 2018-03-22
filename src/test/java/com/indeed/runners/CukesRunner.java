package com.indeed.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
		plugin= {
				"html:target/cucumber-report"}, // it will generate html report 
		tags="",          
		features = "src/test/resources/com/indeed/features",  // from feature class copy qualified name
		glue = "com/indeed/step_defs",                        // from step_defs class Hooks
		dryRun=false
)
public class CukesRunner extends AbstractTestNGCucumberTests {
	

}
