import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class firstBookingTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ronro\\Desktop\\QA\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver ChromeD = new ChromeDriver();
		
		
		try {
		ChromeD.get("https://www.spicejet.com");
		if(ChromeD.getCurrentUrl().contains("spicejet")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		 
		if(ChromeD.getTitle().equals("SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		ChromeD.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		if(ChromeD.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		ChromeD.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		if(ChromeD.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		List<WebElement>  rBtns = ChromeD.findElements(By.cssSelector("input[type=\"checkbox\"]"));
		String trgetBtn = ChromeD.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).getAttribute("id");
		for(int i=0;i<rBtns.size();i++) {
			if(rBtns.get(i).getAttribute("id").equals(trgetBtn)) {
				ChromeD.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
			}
		}
		
		WebElement inputFrom = ChromeD.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		Thread.sleep(1000L);
		inputFrom.click();
		ChromeD.findElement(By.xpath("//a[contains(text(),'Pune (PNQ)')]")).click();
		ChromeD.findElement(By.xpath("(//a[contains(text(),'Delhi (DEL)')])[2]")).click();
		ChromeD.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		Thread.sleep(1000L);
		ChromeD.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Thread.sleep(2000L);
		for(int a=0 ;a < 1;a++) {
			ChromeD.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		}
		ChromeD.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(ChromeD.findElement(By.id("divpaxinfo")).getText(), "2 Adult");
		Select currencySelector = new Select(ChromeD.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		currencySelector.selectByValue("USD");
		ChromeD.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		Thread.sleep(2000L);
		ChromeD.switchTo().alert().accept();
		ChromeD.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
		ChromeD.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		System.out.println("Initial Test Pass!");
		} 
		catch(Exception e) {
			System.out.println(e);
			//ChromeD.close();
		}

	}
}
