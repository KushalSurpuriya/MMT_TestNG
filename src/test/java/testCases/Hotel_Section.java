package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageObjects.Hotel;
import testBase.BaseClass_TNG;
import utilities.ExcelWriteData;

public class Hotel_Section extends BaseClass_TNG{
	
	List<String> count = new ArrayList<String>();
	
	@Test (priority=10, groups= {"smoke","master"})
	public void test_user_clicks_on_hotels_tab() {
		Hotel h = new Hotel(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-550)");
		js.executeScript("arguments[0].click();",h.cli_hotel);
		log.info("User clicks on Hotels tab....");
	}
	
	@Test (priority=11, groups= {"regression","master"})
	public void test_user_clicks_on_guest_button_and_then_on_adults() {
		Hotel h = new Hotel(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",h.cli_guest);
		js.executeScript("arguments[0].click();",h.cli_adults);
		log.info("User clicks on guest button and then on adults....");
	}
	
	@Test (priority=12, groups= {"regression","master"})
	public void get_the_list_of_number_of_adults_and_print_it() throws IOException {
		Hotel h = new Hotel(driver);
	    for (int i=0;i<40;i++) 
	    {
	    	count.add(h.getText(h.get_list.get(i)));
	    	System.out.println(h.getText(h.get_list.get(i)));
	    }
	    
	    assertEquals(count.size(), 40,"Adult List Not Matched");
	    ExcelWriteData.excelWrite(count, cabBooking.lwstPrice, Gift_Card.error_msg);
	    log.info("get the list of number of adults and print it....");
	}

}
