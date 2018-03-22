package com.indeed.step_defs;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.indeed.utilities.ConfigurationReader;
import com.indeed.utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void setUp(Scenario scenario) {
		System.out.println("This runs first before each Scnario starts");
		WebDriver driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window(driver.getWindowHandle());
	}

	@After
	public void tearDown(Scenario scenario) throws InterruptedException {
		if(scenario.isFailed()) {
		//taking a screenshot
		final byte[] screenshot = ((TakesScreenshot) 
		Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
		//adding the screenshot to the report
		scenario.embed(screenshot, "image/png");
		}
		Thread.sleep(3000);
	//	Driver.closeDriver();
	}
}
