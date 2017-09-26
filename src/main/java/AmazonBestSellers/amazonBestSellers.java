package AmazonBestSellers;


import Functions.Functions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import java.util.List;

import static java.lang.Math.abs;

public class amazonBestSellers {
	static String body ="html/body";
	static String amazon = "https://www.amazon.com/";
	static String booksAndAudibles = "//header[contains(@class,'nav-locale')]//div[contains(@class,'nav-flyout')]//div[contains(@class,'nav-flyout-content')]//span[contains(@class,'nav-text') and text()='Books & Audible']";
	static String books = ".//*[@class='fsdDeptCol']//a[contains(@class,'fsdDeptLink') and text()='Books']";
	static String booksSlideout = "//header[contains(@class,'nav-locale')]//div[contains(@class,'nav-flyout')]//div[contains(@class,'nav-subcats')]//div[contains(@class,'nav-panel')]//span[contains(@class,'nav-text') and text()='Books']";
	static String booksAtAmazon = "//div[contains(@class,'a-section')]//img[contains(@alt,'Books at Amazon')]";
	static String bestSellers = ".//*//h2/span[text()='Books Bestsellers']/../..";
	static String booksByTitle (String bookTitle) {return "//div[contains(@class,'a-section')]//div[contains(@class,'rcm widget')]//div[contains(@class,'acswidget')]//div[contains(@class,'a-carousel-viewport')]//div[contains(@class,'a-box-group')]//a[contains(@class,'acs_product-title')]//span[contains(@class,'a-size-small') and title()='"+bookTitle+"']";}
	static String booksByTitleALL = "//div[contains(@class,'a-section')]//div[contains(@class,'rcm widget')]//div[contains(@class,'acswidget')]//div[contains(@class,'a-carousel-viewport')]//div[contains(@class,'a-box-group')]//a[contains(@class,'acs_product-title')]//span[contains(@class,'a-size-small')]";
	public static String bestSellersEntireList = bestSellers+ "//div";
	public static String bestSellersList = bestSellersEntireList+ "//li[contains(@class,'a-carousel-card')]";
	public static String bestSellersBooks = bestSellersList+"/div/a[@title]/span";
	public static String bestSellersAuthors = bestSellersList+"/a[contains(@class,'acs_product-metadata__contributors')]";
	public static String bestSellersBookType = bestSellersList+"/div[contains(@class,'acs_product-metadata__binding')]";
	public static String bestSellersPrice = bestSellersList+ "//span[contains(@class,'acs_product-price__buying')]";
	public static String departments = ".//*[@id='nav-link-shopall']";






	public static void clickShopAllDepartments() throws Exception{
		Functions.waitUntilPresent(100, By.xpath(body));
		if(!Functions.find(By.xpath(departments))){
			System.out.println("Cannot find departments");
			Reporter.log("FAIL");
			Assert.fail();
		}else{
			Reporter.log("PASS");
		}
		Functions.click(By.xpath(departments));
	}

	public static void clickBooks() throws Exception{
		Functions.waitUntilPresent(100, By.xpath(body));
		Functions.scroll(By.xpath(books));
		if(!Functions.find(By.xpath(books))){
			System.out.println("Cannot find books");
			Reporter.log("FAIL");
			Assert.fail();
		}else{
			Reporter.log("PASS");
		}
		Functions.click(By.xpath(books));
	}

	public static void scrollToBestSellers() throws Exception{
		Functions.waitUntilPresent(100, By.xpath(body));
		Functions.scroll(By.xpath(bestSellers));
	}


//
//	public static void hoverOverDepartments() throws Exception{
//		//Functions.waitUntilPresent(100, By.xpath(departments));
//		if(!Functions.find(By.xpath(departments))){
//			System.out.println("Failed at departments");
//			Reporter.log("FAIL");
//			Assert.fail();
//		}else{
//			Reporter.log("PASS");
//		}
//		Functions.hover(By.xpath(departments));
//	}

//	//Hovering over Books and Audibles under Departments slideout
//	public static void hoverOverBooks() throws Exception{
//		Functions.waitUntilPresent(100, By.xpath(booksAndAudibles));
//		if(!Functions.find(By.xpath(booksAndAudibles))){
//			System.out.println("Failed at books and audibles");
//			Reporter.log("FAIL");
//			Assert.fail();
//		}else{
//			Reporter.log("PASS");
//		}
//		Functions.hover(By.xpath(booksAndAudibles));
//	}


//	//slideout Books
//	public static void hoverAndClickBooks() throws Exception{
//		Functions.waitUntilPresent(100, By.xpath(booksSlideout));
//		if(!Functions.find(By.xpath(booksSlideout))){
//			System.out.println("Cannot find books");
//			Reporter.log("FAIL");
//			Assert.fail();
//		}else{
//			Reporter.log("PASS");
//		}
//		Functions.hover(By.xpath(booksSlideout));
//		Functions.click(By.xpath(booksSlideout));
//	}
//
//	public static void booksAtAmazon()throws Exception{
//		Functions.waitUntilPresent(100, By.xpath(booksAtAmazon));
//		if(!Functions.find(By.xpath(booksAtAmazon))){
//			Reporter.log("FAIL");
//			Assert.fail();
//		}else{
//			Reporter.log("PASS");
//		}
//	}


//	public static  void returnText(String by) throws Exception{
////	By by = By.xpath(bestSellersBooks);
//	WebElement we = Functions.findElement(By.xpath(by));
//	String selectedValue = we.getText();
//	System.out.println(selectedValue);
//	}


	
//    public static List<String> getBestSellersList() throws Exception{
//        List<String> books = Functions.getValueFromElements(By.xpath(bestSellersPrice));
//        long currentTime;
//      	long endTime = System.currentTimeMillis() + abs(30)*1000;
//        int temp = 0;
//        do{
//        	currentTime = System.currentTimeMillis();
//            if(!books.isEmpty()){
//                break;
//            }else{
//                Thread.sleep(5000);
//            }
//            if(currentTime > endTime){
//            	Reporter.log("FAIL");
//    			Assert.fail();
//            }
//        }while(currentTime < endTime);
//        return books;
//
//    }



}

