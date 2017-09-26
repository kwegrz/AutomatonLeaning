package test.AmazonBestSellersTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import main.AmazonBestSellers.amazonBestSellers;
import main.Functions.Functions;


public class amazonTest {
	public static String url = "https://www.amazon.com/";
	public static String booksAtAmazon = "//div[contains(@class,'a-section')]//img[contains(@alt,'Books at Amazon')]";
	public static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception{
		Functions.goToURL(url);
	}
	
	@Test
	public static void goToBooks() throws Exception{
		amazonBestSellers.hoverOverDepartments();
		amazonBestSellers.hoverOverBooks();
		amazonBestSellers.clickBooks();
		amazonBestSellers.booksAtAmazon();
	//	amazonBestSellers.bestSellersList();
		
		//RUNIKA HELP!
		// trying to iterate over list to get all the items but not working. Not sure how to do it.
		Map<String, String> objMap = new HashMap<String, String>();
		//objMap.put("Book", Functions.getValue(amazonBestSellers.bestSellersList));
		objMap.put("Title", Functions.getValue(amazonBestSellers.bestSellersBooks));
		objMap.put("Author", Functions.getValue(amazonBestSellers.bestSellersAuthors));
		objMap.put("Type", Functions.getValue(amazonBestSellers.bestSellersBookType));
		objMap.put("Price", Functions.getValue(amazonBestSellers.bestSellersPrice));
		

		
	
		
		List<Object> l = new ArrayList<Object>(objMap.entrySet());
		for(Iterator<?> i = l.iterator(); i.hasNext(); ){
		Map.Entry<String, String> entry = (Map.Entry<String, String>) i.next();
		entry.setValue("new " + entry.getValue());
		}			
	
		System.out.println("Elements of the Map:");
		System.out.println(l);

		}
	}

		


