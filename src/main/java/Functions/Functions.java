package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by kwegrzynowski on 8/14/16.
 */
public class Functions {
    static WebDriver driver = (WebDriver) new FirefoxDriver();

    public static void hoverAndClick(WebElement elementToHover,WebElement elementToClick) {
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).click(elementToClick).build().perform();

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
}

}
