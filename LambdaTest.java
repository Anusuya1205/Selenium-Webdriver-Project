import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LambdaTest {

	public static void main(String[] args) {
        
		
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium_properties\\chromedriver_win32\\chromedriver.exe");
		
		//creating a class
		WebDriver driver=new ChromeDriver();
		
		//maximizig the window
		driver.manage().window().maximize();
		
		//getting the URL
		driver.get("https://www.lambdatest.com/selenium-playground/");
		
		//getting title
		String title = driver.getTitle();
		System.out.println("Page Title : "+title);
		
		//checking logo is presented or not
		WebElement Logo = driver.findElement(By.xpath("//img[@alt='Logo']"));
		if(Logo.isDisplayed())
		{
			System.out.println("Logo is presented");
		}
		else
		{
			System.out.println("Logo is NOT presented");
		}
		
		//numberof links in the webpage
		List<WebElement> link =  driver.findElements(By.tagName("a"));
	    System.out.println("The number of links in this webpage : " + link.size());

	
		//url validation
	    driver.findElement(By.linkText("Simple Form Demo")).click();
        String expectedurl = "https://www.lambdatest.com/selenium-playground/simple-form-demo";
	    String currenturl = driver.getCurrentUrl();
	    if(currenturl.equals(expectedurl)) 
	    {
		   System.out.println("validation passed");
	    }
	    else 
	    {
		   System.out.println("validation failed");

		}
	   
	   //creating a string value using sendKeys()
	   String givenvalue =  "Welcome to Lambdatest";
	   driver.findElement(By.id("user-message")).sendKeys(givenvalue);
	   driver.findElement(By.id("showInput")).click();
	   
	   //geting the string value which is in the input field
	   String gettingvalue = driver.findElement(By.id("message")).getText();
	   
	   //validating given and getting input are same or not
	   if(givenvalue.equals(gettingvalue)) {
		   System.out.println("Value matched");
		   
	   }
	   else {
		   System.out.println("value non-matching");
	   }
	   
	   //getting back  to the home page
	   driver.navigate().back();//remove 
	
		
	   //Click and Hold
	    driver.findElement(By.linkText("Drag & Drop Sliders")).click();
	    Actions action = new Actions(driver);
	    
	    // Select the slider "Default value 15"
	    WebElement slider = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div[2]/div[1]/div/input\r\n"));
	    action.clickAndHold(slider).moveByOffset(0, 0).release().build().perform();

        // Drag the slider to make it 95
	     action.clickAndHold(slider).moveByOffset(202,0).release().build().perform();
	      
	     //getting slider value into a webelement
	     WebElement value = driver.findElement(By.id("rangeSuccess"));
	     String rangeText = value.getText();
	     
	     //validating the slide
	     if(rangeText.equals("95"))
	     {
	    	  System.out.println("Slider validation successfull");
	     }
	     else
	     {
	    	  System.out.println("Slider validation failed");
	     }
	      
		
		//going back to the home page
	     driver.navigate().back();
	    
		
		//entering into the another field
		driver.findElement(By.linkText("Input Form Submit")).click();
		
		//clicking submit button without filling the fields
		driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[6]/button")).click();
		
		//putting wait till popup came
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//checking the popup and validating the message comming in the popup
		WebElement first_name = driver.findElement(By.name("name"));
	    String pleasefilloutthisfield = first_name.getAttribute("validationMessage");
        String expectingText = "Please fill out this field.";
        Assert.assertEquals(pleasefilloutthisfield,expectingText);
        System.out.println("IF USER PUT SUBMIT WITHOUT FILLING THE FIELD : "+pleasefilloutthisfield); 
     
        //Managing DROPDOWN
        
        //using SELECT class
        Select dropdown = new Select(driver.findElement(By.name("country")));
        
        //number of countries in the dropdown
        List<WebElement> list = dropdown.getOptions();
        int listcount = list.size();
        System.out.println("Number of Countries in the DropDown : "+listcount);
        
        
        //select by visible text
         dropdown.selectByVisibleText("India");
         String visibleText = dropdown.getFirstSelectedOption().getText();
         System.out.println("DropDown by VisibleText: "+visibleText);
         
         //select by value
         dropdown.selectByValue("IN");
         String Byvalue = dropdown.getFirstSelectedOption().getText();
         System.out.println("DropDown by SelectByValue : "+Byvalue);
         
         //checking isMultiple
         if(dropdown.isMultiple())
         {
        	 System.out.println("DropDown element allows multiple selections at a time" );
         }
         else
         {
        	 System.out.println("DropDown element NOT allows multiple selections at a time" );
         }
         
        driver.navigate().back();
        
        //handling CheckBox
		driver.findElement(By.linkText("Checkbox Demo")).click();
        WebElement checkbox = driver.findElement(By.id("isAgeSelected"));
         
        //putting for loop checking is the box is checked or not
        for(int i =0; i<2; i++) {
           checkbox.click();
           System.out.println("The CheckBox is Checked "+checkbox.isSelected());
        	 
         }
         
     

        
        
        driver.quit();
	


	}
}	
		



