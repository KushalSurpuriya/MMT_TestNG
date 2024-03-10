package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.OutStationCab;
import testBase.BaseClass_TNG;


public class cabBooking extends BaseClass_TNG{

	String from = "Delhi";
	String to = "Manali, himachal Pradesh";
	public static String lwstPrice;

	@Test (priority=0, groups= {"smoke","master"})
	public void test_user_clicks_on_cab() 
	{
		OutStationCab oc = new OutStationCab(driver);
		//popup
		try {
			driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");	
			if(oc.PopUp().isDisplayed()) {
				oc.PopUp().click();
				Reporter.log("Pop Up Displayed and closed successfully.", true);
				//System.out.println("Pop Up Displayed and closed successfully.");
			}
			driver.switchTo().defaultContent();
			}catch (Exception e) {
				Reporter.log("Pop up not found",true);
				//System.out.println("Pop up not found");
			}
		log.debug("The user launched the webpage.....");
		oc.click(oc.cab_Button);
		log.info("User clicks on cab....");
	}
	
	@Test (priority=1, groups= {"regression","master"})
	public void test_user_enters_from_and_to_locations() throws InterruptedException {
		//From Location
		OutStationCab oc = new OutStationCab(driver);
		oc.click(oc.from_Button);
	    oc.getTextofList(oc.fromTabs, from);
	    //To Location
	    Thread.sleep(1000);
	    try 
	    {
	    	Actions action = new Actions(driver);
			action.sendKeys(oc.toSearchBar, "Manali").build().perform();
	    }catch (Exception e) {
	    	Reporter.log("Trying another input", true);
	    	//System.out.println("Trying another input"); 
	    	oc.toSearchBar.clear();
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('value','Manali')",oc.toSearchBar);
	    	}
	    Thread.sleep(2000);
	    oc.click(oc.toTabs);
	    log.info("User enters from and to locations....");
	}
	
	@Test (priority=2, groups= {"regression","master"})
	public void user_enters_date_and_time_and_click_on_search() {
		OutStationCab oc = new OutStationCab(driver);
		oc.click(oc.cli_date);
		oc.click(oc.cli_time);
		oc.click(oc.cli_search);
		log.info("User enters date and time and click on search....");
	}
	
	@Test (priority=3, groups= {"regression","master"})
	public void user_selects_car_type_as_suv() {
		OutStationCab oc = new OutStationCab(driver);
	    oc.click(oc.cli_SUV);
	    log.info("User selects car type as SUV....");
	}
	
	@Test (priority=4, groups= {"regression","master"})
	public void user_prints_the_lowest_car_price() {
		OutStationCab oc = new OutStationCab(driver);
		lwstPrice = oc.getText(oc.get_price);
		Reporter.log("The Lowest Price of vehicle is : "+ lwstPrice, true);
	    //System.out.println("The Lowest Price of vehicle is : "+ lwstPrice);
	    log.info("User prints the lowest car price....");
	}
}
