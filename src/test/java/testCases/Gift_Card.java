package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageObjects.GiftCard;
import testBase.BaseClass_TNG;


public class Gift_Card extends BaseClass_TNG{
	
	String email = "unknownvmail.com";
	public static String error_msg;
	
	@Test(priority=5, groups= {"regression","master"})
	public void test_user_clicks_on_more_tab_and_selects_giftcard_option() {
		GiftCard gc=new  GiftCard(driver);
		gc.click(gc.cli_more);
		gc.click(gc.cli_giftcard_option);
		log.info("User clicks on more tab and selects Giftcard option....");
	}
	
	@Test(priority=6, groups= {"regression","master"})
	public void test_user_selects_wedding_gift_card_and_selects_email_option() throws InterruptedException {
		GiftCard gc=new  GiftCard(driver);
		gc.click(gc.select_giftcard);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();",gc.cli_email);
	    log.info("User selects wedding gift card and selects Email option....");
	}
	
	@Test(priority=7, groups= {"regression","master","negative"})
	public void test_scrolll_to_that_field_and_enter_invalid_email() {
		GiftCard gc=new  GiftCard(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",gc.cli_email);
		gc.sendKeys(gc.send_email, email);
		log.info("Scrolll to that field and enter invalid email....");
	}
	
	@Test(priority=8, groups= {"regression","master"})
	public void test_click_on_buy_now_and_capture_the_error_message() {
		GiftCard gc=new  GiftCard(driver);
	    gc.click(gc.cli_buy);
	    error_msg = gc.getText(gc.get_message);
	    log.info("click on buy now and capture the error message....");
	}
	
	@Test(priority=9, groups= {"regression","master"})
	public void test_user_prints_the_error_message() {
		System.out.println("The Error message is : "+ error_msg);
		log.info("User prints the error message....");
	}
}
