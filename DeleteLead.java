package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Login
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//Find a lead
		
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
		driver.findElement(By.xpath("//input[@name = 'phoneNumber']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(3000);
		
		//click on First Resulting Lead
		
		WebElement text = driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		String deleteLeadId = text.getText();
		System.out.println(deleteLeadId);
		text.click();
		
		//Deleting the lead
		
		driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
		
		//Searching with the id of the deleted lead
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Lead ID:')]/following::input[@name = 'id']")).sendKeys(deleteLeadId);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(1000);
		
		//Displaying the result 
		
		WebElement result = driver.findElement(By.xpath("//div[@class = 'x-toolbar x-small-editor']//div"));	
		String resultText = result.getText();
		System.out.println(resultText);
		
		//close the browser
		driver.close();
		
		}
        
}