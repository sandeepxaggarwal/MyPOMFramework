package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import POM_Config.Configuration;

public class SelectFlight
{
   WebDriver driver;
   
   public SelectFlight(WebDriver driver){
      this.driver = driver;
   }
   
   
   @FindBy(xpath=Configuration.reserveFlight)
   public WebElement reserveFlight;
   
  
   
   public void doReserve(){
      reserveFlight.click();
      
     
   }
   
   
   public void doLogout(){
      driver.close();
   }
   
   
   
   
   
   
   
   
   
   
   
   
}
