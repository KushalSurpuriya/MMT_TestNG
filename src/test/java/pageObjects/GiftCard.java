package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCard extends BasePage{
	public GiftCard(WebDriver driver) {
		super(driver);
	}

	WebDriver driver;

	@FindBy(xpath="//a[@data-cy='submenu_Giftcards']")
	public WebElement cli_giftcard_option;
	
//	@FindBy(xpath="//li[@data-cy='tertiaryRowItem_Gift Cards']")
//	public WebElement cli_giftcard_option;
	
	@FindBy(xpath="//span[@class='chNavIcon appendBottom2 chSprite chMore']")
	public WebElement cli_more;
	
	@FindBy(xpath="(//div[@class='card__data'])[1]")
	public WebElement select_giftcard;
	
	@FindBy(xpath="//li[@data-cy='DeliveryModes_444'][2]")
	public WebElement cli_email;
	
	@FindBy(xpath="(//input[@data-cy='FormField_082'])[4]")
	public WebElement send_email;
	
	@FindBy(xpath="//div[@class='booking__sections make-flex column'][3]")
	public WebElement cli_buy;
	
	@FindBy(xpath="(//p[@class='red-text font11 append-top5'])[3]")
	public WebElement get_message;
	
	public String getText(WebElement elm) 
	{
		return elm.getText();
	}
	
	public void click(WebElement elm) 
	{
		elm.click();
	}
	
	public void sendKeys(WebElement elm, String str) 
	{
		elm.sendKeys(str);
	}
}
