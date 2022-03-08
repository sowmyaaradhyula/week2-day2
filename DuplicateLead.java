package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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
		
		//find lead using email
		
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		driver.findElement(By.xpath("//input[@name = 'emailAddress']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);
		
		//get first result
		
		WebElement resultLeadId = driver.findElement(By.xpath("(//td[@class = 'x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]//a"));
		
		//get firstname
		
		WebElement firstNameResult = driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-firstName'])[1]/a"));
		String firstName = firstNameResult.getText();
		System.out.println("First Name is :"+firstName);
		
		//clicking on first link
		
		resultLeadId.click();
		Thread.sleep(1000);
		
		//click on duplicate lead
		
		driver.findElement(By.xpath("//a[contains(text(),'Duplicate Lead')]")).click();
		
	    System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@value = 'Create Lead']")).click();
	    
	    //get first name in duplicate lead page
		
	   WebElement duplicateNameResult = driver.findElement(By.id("viewLead_firstName_sp"));
	   String duplicateFirstName = duplicateNameResult.getText();
	   System.out.println("Duplicate First Name is :"+duplicateFirstName);
	   if(firstName.equals(duplicateFirstName))
	   {
		   System.out.println("First Name of First Resultant Lead and duplicate Lead are same");
			   
	   }
	   else
	   {
		   System.out.println("First Name of First Resultant Lead and duplicate Lead are not same");
	   }

	   driver.close();
	}

}
