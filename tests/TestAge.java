package CS1632_Deliverable3.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
As a biography enthusiast
I would like to see in an article about a person's age (if they are living) or their deathdate (if they died already ):
So that my hobby will be completed
 */

public class TestAge {

	static WebDriver driver = new HtmlUnitDriver();
	
	/*
	Given that I am on a biographical page of a living person
	When I try to look for his/her general biography info
	Then I will see their current age
	*/
	@Test
	public void TestAge_LivingPerson() {
		//get person page
		driver.get("https://en.wikipedia.org/wiki/Bill_Gates");
		//get the correct div with the given class -> get the attribute inside
		WebElement e = driver.findElement(By.className("ForceAgeToShow"));
		//assert
		assertTrue(e.isDisplayed());
	}
	
	
	/*
	Given that I am on a biographical page of a dead person
	When I try to look for his/her general biography info
	Then I will see the date when they died
	*/
	@Test
	public void TestAge_DeadPerson() {
		//get person page
		driver.get("https://en.wikipedia.org/wiki/Steve_Jobs");
		//get the correct div with the given class -> get the attribute inside
		WebElement e = driver.findElement(By.className("deathdate"));
		//assert
		assertTrue(e.isEnabled());
	}
	
	
}