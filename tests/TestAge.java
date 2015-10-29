
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

	@Before
	public void turnOffCSSWarnings(){
		java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
		java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
	}

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
	
	
	/*
	Given that I am on a biographical page of a fictional character
	When I try to look for his/her/it general biography
	Then I will not be able to see their real time age/death
	*/
	@Test
	public void TestAge_Fictional() {
		//get person page
		driver.get("https://en.wikipedia.org/wiki/Winnie-the-Pooh");
		//get the correct div with the given class -> get the attribute inside
		try
		{
			WebElement e = driver.findElement(By.className("deathdate"));
			//assert
			assertTrue(e.isEnabled());
		}
		//this test will fail
		catch (NoSuchElementException e)
		{
			//assert here instead of making the test fail on purpose
			//it is less trouble that way, and look 'greener' (pun intended)
			assertTrue(true);
			return;
		}
		fail();
	}
	
	
}