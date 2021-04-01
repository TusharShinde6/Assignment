package sample;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipkartAssignTest {

	@Test
	public void getPriceModulenameReviewOfIphone() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Tushar\\Eclipse Workspace 2020-09\\Assignment\\browser\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
		FlipkartHomePage home=new FlipkartHomePage(driver);
		home.clickFlipkartHomePageCloseBtn();
		home.setFlipkartHomePageSearchMob();
		home.clickFlipkartHomePageSearchIcon();
		
		FlipkartSearchPage search=new FlipkartSearchPage(driver);
		search.getPriceModuleNameReview();
		
	}
}
