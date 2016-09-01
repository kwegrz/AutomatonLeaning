package AmazonBestSellersTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import main.AmazonBestSellers.amazonBestSellers;
import main.Functions.Functions;

/**
 * Created by kwegrzynowski on 8/14/16.
 */
public class amazonTest {
    public static String url = "www.amazon.com";
    public static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception{
        //Functions.goToURL(url);
        driver.navigate().to(url);
    }

    @Test
    public static void goToBooks() throws Exception{
        amazonBestSellers.hoverOverDepartments();
        amazonBestSellers.hoverOverBooks();
        amazonBestSellers.clickBooks();

    }

}

