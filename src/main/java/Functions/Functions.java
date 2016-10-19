package main.Functions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Functions {
	
	static WebDriver driver = new FirefoxDriver();
    
		public void hoverAndClick(By by) {
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(by)).click(driver.findElement(by)).build().perform();
		
	}	
		
		public static void hover(By by) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(by)).perform();
		}
		
		
		public static void click(By by) {
			Actions action = new Actions(driver);
			action.click(driver.findElement(by)).build().perform();
		}
		
		public static void goToURL(String url) throws Exception{
			driver.get(url);
		}
		
		public static boolean find (By by) throws Exception{
			boolean exists = false;
			try{
				driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
				exists =driver.findElements(by).size() != 0;
			} catch (UnhandledAlertException e) {
				Assert.fail();
			} catch (InvalidSelectorException | IllegalArgumentException e) {
				Assert.fail();
			} catch (UnreachableBrowserException e) {
				Assert.fail();
			}
			return exists;
		}
		
		public static void waitUntilPresent(long timeoutInSeconds, By xPath) throws TimeoutException {
			new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(xPath));
		}
		
		public static WebElement findElement(By by) throws Exception{
			return driver.findElement(by);
		}
		
		public static String getValue(String by) throws Exception{
			String valueText = findElement(By.xpath(by)).getText();
			return valueText;
		}
}


