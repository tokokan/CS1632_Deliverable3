package CS1632_Deliverable3.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**

 */

public class TestDirector {

	static WebDriver driver = new HtmlUnitDriver();
	
	/*
	Given that I am on a movie page which is directed by one person
	When I look at the Directed by text
	Then I can see the director's name
	*/
	@Test
	public void TestDirector_Single() {
		//get the movie page
		driver.get("https://en.wikipedia.org/wiki/Saving_Private_Ryan");
		//first check if there is "Directed by text"
		WebElement directedBy = driver.findElement(By.xpath("//div[@id='mw-content-text']/table/tbody/tr[3]/th"));
		if (directedBy.getText().equals("Directed by"))
		{
			//then check if the name of the director is presented
			WebElement director = driver.findElement(By.xpath("//div[@id='mw-content-text']/table/tbody/tr[3]/td"));
			//assert
			assertEquals(director.getText(),"Steven Spielberg");
		}
		else fail();
	}
	
	/*
	Given that I am on a movie page which is directed by 2 person
	When I look at the "Directed by" text
	Then I can see 2 names listed
	 * 
	 */
	@Test
	public void TestDirector_Multiple() {
		//get the movie page
		driver.get("https://en.wikipedia.org/wiki/Shrek");
		//first check if there is "Directed by text"
		WebElement directedBy = driver.findElement(By.xpath("//div[@id='mw-content-text']/table/tbody/tr[3]/th"));
		if (directedBy.getText().equals("Directed by"))
		{
			//then check if there are 2 directors name
			List<WebElement> directors = driver.findElements(By.xpath("//div[@id='mw-content-text']/table/tbody/tr[3]/td/div/ul/li"));
			//assert
			assertEquals(directors.size(),2);
		}
		else fail();
	}
		
	
}