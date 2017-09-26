package Functions;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


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


	/**
	 * Scrolls to the page element
	 *
	 * @param by
	 *            the XPath to the element
	 * @throws Exception
	 */
	public static void scroll(By by) throws Exception {
		try {
			WebElement target = driver.findElement(by);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", target);
			Thread.sleep(200);
			Reporter.log("scroll to element");
		} catch (StaleElementReferenceException e) {

		} catch (Exception | Error e) {
			System.out.println("Cannot find item");
			Reporter.log("FAIL");
			Assert.fail();
		}
	}

	/**
		 * Gets the value of the specified attribute for the list of elements
		 * @param by                 the XPath to the list of elements
		// * @param attribute          the attribute from which to get the value
		 * @return                   the list of attribute's value
		 * @throws Exception
		 */
		public static List<String>getValueFromElements(By by) throws Exception {
				List<String> valueList = new ArrayList<String>();
				if(find(by)){
					for (WebElement element : driver.findElements(by)) {
					//	if (attribute.equalsIgnoreCase("text")) 
							valueList.add(element.getText());
						//else
							//valueList.add(element.getAttribute(attribute));
					}
				}
				return valueList;
			}
}



