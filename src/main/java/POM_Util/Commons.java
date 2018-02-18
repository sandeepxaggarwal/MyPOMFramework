package POM_Util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import POM_Core.Page;



public class Commons extends Page
{
   public static boolean isExecutable(String tc)
   {
      int rows = excel.getRowCount("TestSuite");
      for (int rowNum = 2; rowNum <= rows; rowNum++)
      {
         if (excel.getCellData("TestSuite", 1, rowNum).contentEquals(tc))
         {
            if (excel.getCellData("TestSuite", 3, rowNum).equalsIgnoreCase("Y"))
            {
               return true;
            }
         }

      }

      return false;

   }

   public static String captureScreenshot(String methodname) throws IOException
   {
      Calendar cal = new GregorianCalendar();
      int year = cal.get(Calendar.YEAR);
      int month = cal.get(Calendar.MONTH);
      int day = cal.get(Calendar.DAY_OF_MONTH);
      int hour = cal.get(Calendar.HOUR);
      int minute = cal.get(Calendar.MINUTE);
      int second = cal.get(Calendar.SECOND);

      String Screenshotpath = System.getProperty("user.dir") + "\\Screenshots\\" + methodname + "_" + year + month + day + hour + minute + second + ".png";
      File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(file, new File(Screenshotpath));
      return Screenshotpath;

   }

   public static Object[][] getData(String tc)
   {
      int rows = excel.getRowCount(tc);
      int cols = excel.getColumnCount(tc);
      Object[][] data = new Object[rows - 1][cols];
      for (int rowNum = 2; rowNum <= rows; rowNum++)
      {
         for (int colNum = 1; colNum <= cols; colNum++)
         {
            data[rowNum - 2][colNum - 1] = excel.getCellData(tc, colNum, rowNum);
         }
      }
      return data;
   }
}
