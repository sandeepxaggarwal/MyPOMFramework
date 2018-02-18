package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import POM_Config.Configuration;
//LoginPage Class
public class LoginPage
{
   WebDriver driver;
   
   public LoginPage(WebDriver driver){
      this.driver = driver;
   }
   
  // WebElement x = driver.findElement(By.xpath("//input[@name='userName"));
   @FindBy(how=How.XPATH,using=Configuration.username)
   public WebElement username;
   
   @FindBy(how=How.XPATH,using=Configuration.password)
   public WebElement password;
   
   @FindBy(xpath=Configuration.signin)
   public WebElement signin;
   
   
   public FlightFinder doLogin(String myusername,String mypassword){
      username.sendKeys(myusername);
      password.sendKeys(mypassword);
      signin.click();
      
    return PageFactory.initElements(driver, FlightFinder.class);
      
     
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
}
