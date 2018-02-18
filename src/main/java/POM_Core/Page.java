package POM_Core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;




import POM_Util.Xlfile_Reader;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class Page
{
   public static WebDriver driver;

   public static Xlfile_Reader excel = new Xlfile_Reader(System.getProperty("user.dir") +"\\src\\test\\java\\POM_TestData\\TestData.xlsx");

   private static final Logger logger = LoggerFactory.getLogger(Page.class);
   public static ExtentReports extent = new ExtentReports("Reports.html");
   public static FileInputStream fis;
   public static Properties Config;
   public static Properties OR;
   public static ExtentTest test;

   @BeforeSuite
   public void init() throws IOException
   {
      fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\POM_Config\\Config.properties");
      Config = new Properties();
      Config.load(fis);

      if (Config.getProperty("browser").contentEquals("firefox"))
      {
         driver = new FirefoxDriver();
      }
      else if (Config.getProperty("browser").contentEquals("chrome"))
      {
         System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
         driver = new ChromeDriver();
      }
      else if (Config.getProperty("browser").contentEquals("ie"))
      {
         System.setProperty("webdriver.chrome.driver", "IEDriverServer.exe");
         driver = new InternetExplorerDriver();
      }
      logger.info("Launch the website");
      driver.get(Config.getProperty("testsiteurl"));
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      
      /*fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\DD_Config\\OR.properties");
      OR = new Properties();
      OR.load(fis);*/

   }
   
   @AfterSuite
   public void close(){
      driver.close();
      extent.flush();
      extent.close();
   }

}
