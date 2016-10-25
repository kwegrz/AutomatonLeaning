package main.AmazonBestSellers;


import static java.lang.Math.abs;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import main.Functions.Functions;

public class amazonBestSellers {
	static String amazon = "https://www.amazon.com/";
	static String departments = "//header[contains(@class,'nav-locale')]//div[contains(@class,'nav-sprite-v1')]//div[contains(@class,'nav-sprite')]//div[contains(@class,'nav-left')]//a[contains(@class,'nav-a')]//span[contains(@class,'nav-line-2')]";
	static String booksAndAudibles = "//header[contains(@class,'nav-locale')]//div[contains(@class,'nav-flyout')]//div[contains(@class,'nav-flyout-content')]//span[contains(@class,'nav-text') and text()='Books & Audible']";
	static String books = "//header[contains(@class,'nav-locale')]//div[contains(@class,'nav-flyout')]//div[contains(@class,'nav-subcats')]//div[contains(@class,'nav-panel')]//span[contains(@class,'nav-text') and text()='Books']";
	static String booksAtAmazon = "//div[contains(@class,'a-section')]//img[contains(@alt,'Books at Amazon')]";
	static String bestSellers = "//div[contains(@class,'a-section')]//div[contains(@class,'rcm widget')]//div[contains(@class,'acswidget')]//h3[contains(@class,'a-spacing-mini')]//span[contains(@class,'acswidget-carousel__title') and text()='Books best sellers']";
	static String booksByTitle (String bookTitle) {return "//div[contains(@class,'a-section')]//div[contains(@class,'rcm widget')]//div[contains(@class,'acswidget')]//div[contains(@class,'a-carousel-viewport')]//div[contains(@class,'a-box-group')]//a[contains(@class,'acs_product-title')]//span[contains(@class,'a-size-small') and title()='"+bookTitle+"']";}
	static String booksByTitleALL = "//div[contains(@class,'a-section')]//div[contains(@class,'rcm widget')]//div[contains(@class,'acswidget')]//div[contains(@class,'a-carousel-viewport')]//div[contains(@class,'a-box-group')]//a[contains(@class,'acs_product-title')]//span[contains(@class,'a-size-small')]";
	public static String bestSellersEntireList = "//div[contains(@class,'a-section')]//div[contains(@class,'rcm widget')]//div[contains(@class,'acswidget')]//h3[contains(@class,'a-spacing-mini')]//span[contains(@class,'acswidget-carousel__title') and text()='Books Bestsellers']/parent::h3/following-sibling::div//div[contains(@class,'a-carousel-viewport')]//ol[contains(@class,'a-carousel')]";
	public static String bestSellersList =    bestSellersEntireList+ "//li[contains(@class,'a-carousel-card')]";
	public static String bestSellersBooks = bestSellersList+"//div[contains(@class,'a-box-group')]//a[contains(@class,'acs_product-title')]//span[contains(@class,'a-size-small')]";
	public static String bestSellersAuthors = bestSellersList+"//div[contains(@class,'acs_product-metadata__contributors')]";
	public static String bestSellersBookType = bestSellersList+"//div[contains(@class,'acs_product-metadata__binding')]";
	public static String bestSellersPrice = bestSellersList+ "//span[contains(@class,'acs_product-price__buying')]";
	
	public static void hoverOverDepartments() throws Exception{
		//Functions.waitUntilPresent(100, By.xpath(departments));
		if(!Functions.find(By.xpath(departments))){
			System.out.println("Failed at departments");
			Reporter.log("FAIL");
			Assert.fail();
		}else{
			Reporter.log("PASS");
		}
		Functions.hover(By.xpath(departments));
	}
	
	public static void hoverOverBooks() throws Exception{
		//Functions.waitUntilPresent(100, By.xpath(booksAndAudibles));
		if(!Functions.find(By.xpath(booksAndAudibles))){
			System.out.println("Failed at books and audibles");
			Reporter.log("FAIL");
			Assert.fail();
		}else{
			Reporter.log("PASS");
		}
		Functions.hover(By.xpath(booksAndAudibles));
		Thread.sleep(4000);
	}
	
	public static void clickBooks() throws Exception{
		//Functions.waitUntilPresent(100, By.xpath(books));
		if(!Functions.find(By.xpath(books))){
			System.out.println("Cannot find books");
			Reporter.log("FAIL");
			Assert.fail();
		}else{
			Reporter.log("PASS");
		}
		Functions.click(By.xpath(books));
	}
	
	public static void booksAtAmazon()throws Exception{
		Thread.sleep(2000);
		if(!Functions.find(By.xpath(booksAtAmazon))){
			Reporter.log("FAIL");
			Assert.fail();
		}else{
			Reporter.log("PASS");
		}
	}
	
	public static  void returnText(String by) throws Exception{
//	By by = By.xpath(bestSellersBooks);
	WebElement we = Functions.findElement(By.xpath(by));
	String selectedValue = we.getText();
	System.out.println(selectedValue);
	}
	
    public static List<String> getBestSellersList() throws Exception{
        List<String> books = Functions.getValueFromElements(By.xpath(bestSellersPrice));
        long currentTime;
      	long endTime = System.currentTimeMillis() + abs(30)*1000;
        int temp = 0;
        do{
        	currentTime = System.currentTimeMillis();
            if(!books.isEmpty()){
                break;
            }else{
                Thread.sleep(5000);
            }
            if(currentTime > endTime){
            	Reporter.log("FAIL");
    			Assert.fail();
            }
        }while(currentTime < endTime);
        return books;
        
    }

	
}

