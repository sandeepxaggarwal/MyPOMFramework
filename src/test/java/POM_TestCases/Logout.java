package POM_TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM_Core.Page;
import POM_Pages.FlightFinder;
import POM_Pages.LoginPage;
import POM_Pages.SelectFlight;
import POM_Util.Commons;

import com.relevantcodes.extentreports.LogStatus;

public class Logout extends Page
{
   @BeforeTest
   public void isSkip()
   {
      if (!Commons.isExecutable("Logout"))
      {
         throw new SkipException("Skipping testcase as Run Mode is No");
      }
   }

   @Test(dataProvider = "getData")
   public void doLogin(String username, String password)
   {
     // test = extent.startTest("Execution of doLogin Test");
      SelectFlight sf = PageFactory.initElements(driver, SelectFlight.class);
      sf.doLogout();
   }

   @AfterMethod
   public void afterTest(ITestResult result) throws IOException
   {
      System.out.println(result.getStatus());
      if (ITestResult.SUCCESS == result.getStatus())
      {
         test.log(LogStatus.PASS, "Test Case doLogin is passed");
      }
      else if (ITestResult.FAILURE == result.getStatus())
      {
         String methodname = result.getName();
         test.log(LogStatus.FAIL, "Test Case doLogin is failed" + test.addScreenCapture(Commons.captureScreenshot(methodname)));

      }
      extent.endTest(test);
   }

   @DataProvider
   public Object[][] getData()
   {

      return Commons.getData("LoginTest");

   }
}