package AmazonBestSellers;

/**
 * Created by kwegrzynowski on 8/14/16.
 */
public class amazonBestSellers {
    static String departments = "//header[contains(@class,'nav-locale')]//div[contains(@class,'nav-sprite-v1')]//div[contains(@class,'nav-sprite')]//div[contains(@class,'nav-left')]//a[contains(@class,'nav-a')]//span[contains(@class,'nav-line-2')]";
    static String booksAndAudibles = "//header[contains(@class,'nav-locale')]//div[contains(@class,'nav-flyout')]//div[contains(@class,'nav-flyout-content')]//span[contains(@class,'nav-text') and text()='Books & Audible']";
    static String books = "//header[contains(@class,'nav-locale')]//div[contains(@class,'nav-flyout')]//div[contains(@class,'nav-subcats')]//span[contains(@class,'nav-title')]//span[contains(@class,'nav-text') and text()='Books']";

    public static void hoverOverDepartments() throws Exception{
        Functions.hover(By.xpath(departments));
    }

    public static void hoverOverBooks() throws Exception{
        Functions.hover(By.xpath(booksAndAudibles));
    }

    public static void clickBooks() throws Exception{
        Functions.click(By.xpath(books));
    }
}