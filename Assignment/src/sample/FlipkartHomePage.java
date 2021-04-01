package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage {

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']") private WebElement closebtn;
	@FindBy(xpath = "//input[@class='_3704LK']") private WebElement search;
	@FindBy(xpath = "//button[@class='L0Z3Pu']") private WebElement searchIcon;
	
	
	public FlipkartHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickFlipkartHomePageCloseBtn() {
		closebtn.click();
	}
	
	public void setFlipkartHomePageSearchMob() {
		search.sendKeys("iphone");
	}
	
	public void clickFlipkartHomePageSearchIcon() {
		searchIcon.click();
	}
	
	
	
}
