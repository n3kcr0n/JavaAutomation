import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class Chrome {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ronro\\Desktop\\QA\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //create the object of the browser
		try {
			/*	  
			Cdriver.get("https://login.salesforce.com/"); //open the browser
			Cdriver.findElement(By.xpath("//*[@id=\'username\']")).sendKeys("User1"); //find the element by ID
			Cdriver.findElement(By.xpath("//*[@id=\'password\']")).sendKeys("pass123");
			Cdriver.findElement(By.xpath("//*[@id=\'Login\']")).click();
			String err = Cdriver.findElement(By.cssSelector("div#error.loginError")).getText();
			System.out.println(err); 
			*/
			
			//HANDLING Select COMPONENTS
			 
			driver.get("https://www.spicejet.com");
			
			driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
			if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
				System.out.println("Enabled");
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}

//			driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
//			Assert.assertFalse(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());//use the isEnabled for checking element that is enabled
			
			
			List<WebElement>  rBtns = driver.findElements(By.cssSelector("input[type=\"checkbox\"]"));
			WebElement trgetBtn = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
			Assert.assertFalse(trgetBtn.isSelected());
			for (int i = 0; i<rBtns.size(); i++) {
				if(rBtns.get(i).getAttribute("id").equals("ctl00_mainContent_chk_friendsandfamily")) {
					rBtns.get(i).click();
					System.out.println("radio button selected? " + rBtns.get(i).isSelected());
					Assert.assertTrue(rBtns.get(i).isSelected());
				}
			}
			System.out.println("radio buttons are " +rBtns.size());
			
			
			Select curSelect = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']")));
			curSelect.selectByValue("USD");
			//curSelect.selectByIndex(3);
			//curSelect.selectByVisibleText("AED");
			driver.findElement(By.id("divpaxinfo")).click();
			Thread.sleep(2000L);
			
//			int i = 0;
//			while(i < 4) {
//				driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
//				i++;
//			}
			
			for(int a=0;a< 4;a++) {
				driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
			}
			
			Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
			//System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			driver.findElement(By.id("btnclosepaxoption")).click();
			driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
			driver.findElement(By.xpath("//a[@value='PNQ']")).click();
			Thread.sleep(2000L);
			driver.findElement(By.xpath("(//a[@value='VTZ'])[2]")).click(); 
			driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
			//driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
			
			
			//driver.close();
			}
			
			/*
			//Handling Dynamic Dropdowns
		
			WebElement inputFrom = driver.findElement(By.xpath("//input[@id='fromCity']"));
			driver.manage().window().maximize();
			driver.get("https://www.makemytrip.com/");
			inputFrom.click();
			driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("manila");
			driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(Keys.ENTER);
			
			// Handling Radio Buttons
			
			driver.manage().window().maximize();
			driver.get("http://echoecho.com/htmlforms10.htm");
			driver.findElement(By.xpath("//input[@value='Cheese']")).click();
			int rNum = driver.findElements(By.xpath("//input[@name='group1']")).size();
			
			
			List<WebElement> radio = driver.findElements(By.xpath("//input[@name='group1']"));
				for(int i=0;i<rNum;i++ ) {
	//				radio.get(i).click(); //using the get() method to click an element in multiple elements
	//				Thread.sleep(1000L);
	//				System.out.println(radio.get(i).getAttribute("value")); //using the getAttribute() method 
					if(radio.get(i).getAttribute("value").equals("Cheese")) { //using the equals() method
						System.out.println(radio.get(i).getAttribute("value"));
						radio.get(i).click();
					}
				}	
				
			
			//Handling Alerts 
			
			driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
			WebElement popUp = driver.findElement(By.xpath("//input[@value='Confirmation Alert']"));
			popUp.click();
			Thread.sleep(2000L);
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();// switching the driver to alert to exit the popup then use the accept or the dismiss method
			//driver.switchTo().alert().sendKeys("test");//enter in put for JSpromts
			 */
			
			
			
			
			catch(Exception e) {
			 System.out.println(e);
			 driver.close();
			}
		}
}
