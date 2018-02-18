package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import POM_Config.Configuration;

public class FlightFinder
{
   WebDriver driver;
   
   public FlightFinder(WebDriver driver){
      this.driver = driver;
   }
   
   
   @FindBy(xpath=Configuration.tripType)
   public WebElement tripType;
   
   @FindBy(xpath=Configuration.findFlights)
   public WebElement findFlights;
   
      
   public SelectFlight doFindFlight(){
      tripType.click();
      findFlights.click();
      
      return PageFactory.initElements(driver, SelectFlight.class);
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
}
