import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by John on 10/29/2015.
 */

/*
As a citizen of Otter, Ontario
I want to be able to find the wikipedia page of my hometown
So that I can add important local information
 */
public class TestDisambiguation {

    static WebDriver driver = new FirefoxDriver();

    @Before
    public void turnOffCSSWarnings(){
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
    }
    /*
    Given that I am on a wikipedia page with disambiguation
    When I click the 'page-name (disambiguation)' link
    Then I should arrive at the disambiguation page
     */
    @Test
    public void TestOpenDisambiguationFromAmbiguousPage(){
        driver.get("https://en.wikipedia.org/wiki/Otter");
        driver.findElement(By.linkText("Otter (disambiguation)")).click();
        String url = driver.getCurrentUrl();
        assert url.contains("_(disambiguation)");
    }

    /*
    Given that I am on a disambiguation page
    When I select a navigation element from the Contents bar
    Then I should be moved to that section of the contents
     */
    @Test
    public void TestNavigateDisambiguationByContents(){
        //create a separate driver for this because the contents bar saves its state between sessions
        WebDriver ndriver = new FirefoxDriver();
        try{
            ndriver.get("https://en.wikipedia.org/wiki/Otter");
            ndriver.findElement(By.linkText("Otter (disambiguation)")).click();
            ndriver.findElement(By.cssSelector(".toclevel-1.tocsection-1 a")).click();
            String url = ndriver.getCurrentUrl();
            assert url.contains("#Places");
        }
        finally {
            ndriver.quit();
        }
    }
    /*
    Given that I am at the disambiguation page
    When I toggle to hide the Contents Bar
    The contents should no longer be visible
     */
    @Test
    public void TestCloseNavigateContents(){
        driver.get("https://en.wikipedia.org/wiki/Otter");
        driver.findElement(By.linkText("Otter (disambiguation)")).click();
        driver.findElement(By.id("togglelink")).click();
        WebElement contents = driver.findElement(By.cssSelector("#toc ul"));
        //sleep for JQuery
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert !contents.isDisplayed();
    }
    /*
    Given that I am on the disambiguation page
    When I select the Wikitionary link
    I should be moved to a Wikitionary URL
     */
    @Test
    public void TestDisambiguationWikitionaryLink(){
        driver.get("https://en.wikipedia.org/wiki/Otter");
        driver.findElement(By.linkText("Otter (disambiguation)")).click();
        driver.findElement(By.linkText("Otter")).click();
        String url = driver.getCurrentUrl();
        assert url.equals("https://en.wiktionary.org/wiki/Otter");
    }
    /*
    Given that I am on the disambiguation page
    When I select a link in the body
    I should be moved to a url that is a disambiguation of the original page
     */
    @Test
    public void TestDisambiguationLinksToCorrectPage(){
        driver.get("https://en.wikipedia.org/wiki/Otter");
        driver.findElement(By.linkText("Otter (disambiguation)")).click();
        driver.findElement(By.linkText("Otter, Montana")).click();
        String url = driver.getCurrentUrl();
        assert url.contains("Otter,_Montana");
    }
}
