package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass_TNG {
	
	public static WebDriver driver;
	//Loading log4j file
	public Logger log = LogManager.getLogger(this.getClass());
	public static Properties p;
	
	@BeforeTest (groups= {"sanity","regression","master"})
	@Parameters({"os", "browser"})
	public static void setup(String os, String br) throws IOException 
	{
		//loading properties file
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p= new Properties();
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) 
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//OS
			if(os.equalsIgnoreCase("windows")) 
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac")) 
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else 
			{
				System.out.println("No Matching os....");
				return;
			}
			
			//browser
			if(br.toLowerCase().equalsIgnoreCase("chrome")) 
			{
				capabilities.setBrowserName("chrome");
			}
			else if(br.toLowerCase().equalsIgnoreCase("edge")) 
			{
				capabilities.setBrowserName("MicrosoftEdge");
			}
			else 
			{
				System.out.println("No Matching Browser....");
				return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities);
		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local")) 
		{
			//launching the browser based on condition
			if (br.toLowerCase().equals(("chrome"))) 
			{
				driver = new ChromeDriver();
			}
			else if (br.toLowerCase().equals("edge")) 
			{
				driver = new EdgeDriver();
			}
			else {System.out.println("No matching browser");
				return;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterTest (groups= {"sanity","regression","master"})
	public static void tearDown() 
	{
		driver.quit();
	}
	
	public static String randomString() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String captureScreen(String tname) 
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}


}
