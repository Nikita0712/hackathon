package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
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
import org.testng.annotations.*;


public class BaseClass {

	public static WebDriver driver; 
	public static Logger logger; 
	public Properties p;
	@BeforeTest
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException
	{

		FileReader file=new FileReader(".//src/test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		//loading logger file
		logger=LogManager.getLogger(this.getClass());
	
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
					DesiredCapabilities capabalities = new DesiredCapabilities();
					//os
					if(os.equalsIgnoreCase("windows")) {
						capabalities.setPlatform(Platform.WIN11);
					}
					else if (os.equalsIgnoreCase("mac")) {
						capabalities.setPlatform(Platform.MAC);
					}
					else {
						System.out.println("no matching os .....");
						return;
					}
					//browser
					if(br.equalsIgnoreCase("chrome")) {
						capabalities.setBrowserName("chrome");
					}
					else if(br.equalsIgnoreCase("edge")) {
						capabalities.setBrowserName("MicrosoftEdge");
					}
					else {
						System.out.println("no matching browser .....");
						return;
					}
		 
					 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") , capabalities);
				}
				else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		if(br.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver(); 
		}
		else if(br.equalsIgnoreCase("Edge")) 
		{
			driver=new EdgeDriver(); 
		}
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	}
	
	
  	public String captureScreen(String tname) throws IOException 
  	{									
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\" + tname + ".png";                          
		File targetFile=new File(targetFilePath);
		FileUtils.copyFile(sourceFile, targetFile);
		return targetFilePath;

	}

     @AfterTest
     public void tearDown()
    {
    	 driver.quit();
    }
}
