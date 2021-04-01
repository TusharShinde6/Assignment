package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencsv.CSVWriter;

public class FlipkartSearchPage {

	WebDriver driver;
	public FlipkartSearchPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	static CSVWriter writer;

	public static String removeSpclCharFromNumber(String originalStr) {
		String resultStr = "";
		// loop execute till the length of the string
		for (int i = 0; i < originalStr.length(); i++)
		{
			// comparing alphabets with their corresponding ASCII value
			if (originalStr.charAt(i) >= 48 && originalStr.charAt(i) <= 57) // returns true if both conditions returns																			// true
			{
				// adding characters into empty string
				resultStr = resultStr + originalStr.charAt(i);
			}
		}
		System.out.println("String after removing special characters: " + resultStr);

		return resultStr;
	}

	public static void writeDataToCSVFile(int count, String Price, String ModelName, String Review) throws IOException {
		// first create file object for file placed at location
		// specified by filepath
		
		try {
			
			if (count == 1)
			{			
				File file = new File("D:\\Tushar\\Eclipse Workspace 2020-09\\Assignment\\CSVFile\\sample1.csv");
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			writer = new CSVWriter(outputfile);

			// adding header to csv			
				String[] header = { "ModelName", "Price","Review" };
				writer.writeNext(header);
			}
			// add data to csv
			String[] data1 = { ModelName, Price, Review };
			writer.writeNext(data1);

			// closing writer connection

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public void getPriceModuleNameReview() throws InterruptedException, IOException {
		Thread.sleep(2000);

		List<WebElement> AllPrices = driver.findElements(By.xpath("//div[@class='_30jeq3']"));

		List<WebElement> modelNames = driver.findElements(By.xpath("//a[@class='s1Q9rs']"));
		
		List<WebElement> AllReviews = driver.findElements(By.xpath("//span[@class='_2_R_DZ']"));
		
		int count = 0;
		for (int i = 0; i <= AllPrices.size() - 1; i++) {

			String price = AllPrices.get(i).getText();
			
			String price1 = removeSpclCharFromNumber(price);
			int priceInInt = Integer.parseInt(price1);

			if (priceInInt <= 40000) {				
				String modelName = modelNames.get(i).getText();
				if(modelName.startsWith("APPLE iPhone")) {
					count=count+1;
					String Review = AllReviews.get(count).getText();			
					writeDataToCSVFile(count, price, modelName,Review);
				}
			}

		}

		writer.close();
	}
	
	
	
	
	
	
	
	
}
