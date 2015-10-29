
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.*;

/*
 As a Biologist
 I would like to be able to log in
 So that I can add pages about my specialties to my watchlist
 */

public class TestLoginAndLogout {


	@Before
	public void turnOffCSSWarnings(){
		java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
		java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
	}

	/*
	Given that I am on a wikipedia page and not logged in
	When I press the button to log in
	I will be taken to a log-in page
	 */
	@Test
	public void TestLogInButtonLinksToLogInPage() {
		WebDriver driver = new FirefoxDriver();
		try{
			//Open the webpage
			driver.get("https://en.wikipedia.org/wiki/Otter");
			//find the text that says log in
			driver.findElement(By.linkText("Log in")).click();
			//enter the username into the username box
			String url = driver.getCurrentUrl();
			//assert that the page is at the correct url
			assert url.contains("title=Special:UserLogin");
		}
		//reset cookies to log out the user
		finally {
			driver.quit();
		}
	}

	/*
	Given that I am on a wikipedia page
	When I try to log into an account with valid credentials
	Then my username will be displayed on the next page
	*/

	@Test
	public void TestLogInSucceedsWithCorrectInformation() {
		WebDriver driver = new FirefoxDriver();
		try{
			//Open the webpage
			driver.get("https://en.wikipedia.org/wiki/Otter");
			//find the text that says log in
			driver.findElement(By.linkText("Log in")).click();
			//enter the username into the username box
			driver.findElement(By.id("wpName1")).clear();
			driver.findElement(By.id("wpName1")).sendKeys("CS1632testaccount");
			//enter the password into the password box
			driver.findElement(By.id("wpPassword1")).clear();
			driver.findElement(By.id("wpPassword1")).sendKeys("laboooooon");
			//attempt to log in
			driver.findElement(By.id("wpLoginAttempt")).click();
			//Assert that the username is shown on the page
			try{
				driver.findElement(By.linkText("CS1632testaccount"));
				assert true;
			}
			catch (NoSuchElementException e){
				assert false;
			}
		}
		//reset cookies to log out the user
		finally {
			driver.quit();
		}
	}

	/*
	Given that I am on a wikipedia page
	When I try to log into an account with invalid credentials, such as a swapped username and password
	Then my username will be not displayed on the next page
	*/

	@Test
	public void TestLoginFailsWithSwappedUsernameAndPassword(){
		WebDriver driver = new FirefoxDriver();
		try{
			//Open the webpage
			driver.get("https://en.wikipedia.org/wiki/Otter");
			//find the text that says log in
			driver.findElement(By.linkText("Log in")).click();
			//enter the username into the username box
			driver.findElement(By.id("wpName1")).clear();
			driver.findElement(By.id("wpName1")).sendKeys("laboooooon");
			//enter the password into the password box
			driver.findElement(By.id("wpPassword1")).clear();
			driver.findElement(By.id("wpPassword1")).sendKeys("CS1632testaccount");
			//attempt to log in
			driver.findElement(By.id("wpLoginAttempt")).click();
			//Assert that the username is not shown on the page
			try{
				driver.findElement(By.linkText("CS1632testaccount"));
				assert false;
			}
			catch (NoSuchElementException e){
				assert true;
			}
		}
		//reset cookies to log out the user
		finally {
			driver.quit();
		}
	}
	/*
	Given that I am on a wikipedia page and logged in
	When I try to clock on the log out button
	Then I will no longer be logged in to wikipedia
	 */
	@Test
	public void TestLogoutIfLoggedIn(){
		WebDriver driver = new FirefoxDriver();
		driver.get("https://en.wikipedia.org/wiki/Otter");
		//log in
		LogIn(driver);
		try{
			driver.findElement(By.linkText("Log out")).click();
			//Assert that the option to Log In is shown on the page
			try{
				driver.findElement(By.linkText("Log in"));
				assert true;
			}
			catch (NoSuchElementException e){
				assert false;
			}
		}
		//reset cookies to log out the user
		finally {
			driver.quit();
		}
	}
	/*
	Given that I am on a wikipedia page and logged in
	When another tap is open and navigated to wikipedia
	Then I will still be logged in
	 */
	@Test
	public void TestNewTabStillLoggedIn(){
		WebDriver driver = new FirefoxDriver();
		WebDriverBackedSelenium s = new WebDriverBackedSelenium(driver, "https://en.wikipedia.org/wiki/Otter");
		driver.get("https://en.wikipedia.org/wiki/Otter");
		//log in
		LogIn(driver);
		//Open a new window with a different wikipedia page
		s.openWindow("https://en.wikipedia.org/wiki/Oriental_small-clawed_otter", "theNewWindow");
		//Assert that the option to Log out is shown on the page
		try{
			driver.findElement(By.linkText("Log out"));
			assert true;
		}
		catch (NoSuchElementException e){
			assert false;
		}
		//reset cookies to log out the user
		finally {
			driver.quit();
		}
	}


	//this function automates logging in
	public void LogIn(WebDriver driver){
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("wpName1")).clear();
		driver.findElement(By.id("wpName1")).sendKeys("CS1632testaccount");
		driver.findElement(By.id("wpPassword1")).clear();
		driver.findElement(By.id("wpPassword1")).sendKeys("laboooooon");
		driver.findElement(By.id("wpLoginAttempt")).click();
	}


}