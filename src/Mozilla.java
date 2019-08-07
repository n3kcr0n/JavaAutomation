import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Mozilla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ronro\\Desktop\\QA\\Webdrivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions()
				.setProfile(new FirefoxProfile());
		WebDriver Mdriver = new FirefoxDriver(options);
		Mdriver.get("http://google.com");
		System.out.println(Mdriver.getTitle());
	}

}
