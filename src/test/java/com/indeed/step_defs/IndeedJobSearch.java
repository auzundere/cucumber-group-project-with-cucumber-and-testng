package com.indeed.step_defs;


import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import com.indeed.pages.HomePage;
import com.indeed.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class IndeedJobSearch {
String job;
String where;
	HomePage homePage=new HomePage();
	@Given("^I navigate the website indeed$")
	public void i_navigate_the_website_indeed() {
		
		String title="Job Search | Indeed";
		assertTrue(homePage.verifyTitle(title),"Title was not same as"+title);
		String URL="https://www.indeed.com/";
		assertTrue(homePage.verifyURL(URL), "URL is not same as expected one");
		assertTrue(homePage.whatLabel.getText().equals("what"), "The expected label text was not 'what'");
		assertTrue(homePage.whereLabel.getText().equals("where"), "The expected label text was not 'where'");
	}

	@Given("^I enter \"([^\"]*)\" in What search box and I enter \"([^\"]*)\" in Where Box and Search$")
	public void i_enter_in_What_search_box_and_I_enter_in_Where_Box_and_Search(String what, String where) {
		 homePage.text_input_what.sendKeys(what);
		 homePage.text_input_where.click();
		homePage.text_input_where.clear();
	    homePage.text_input_where.sendKeys(where);
	    homePage.findJobsButton.click();
		job=what.toLowerCase();
		this.where=where.toLowerCase();
	}

	@When("^I verify the title has search arguments$")
	public void i_verify_the_title_has_search_arguments() {
		assertTrue(homePage.getTitle().contains(job),"The title has not contain"+job);
		assertTrue(homePage.getTitle().contains(where),"The title has not contain"+this.where);
	    
	}
}
