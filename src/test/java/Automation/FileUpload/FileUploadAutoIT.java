package Automation.FileUpload;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class FileUploadAutoIT {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		String downloadPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Projects\\chromedriver.exe");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\FileUpload.exe");
		
		driver.findElement(By.id("processTaskTextBtn")).click();		
		driver.findElement(By.id("pickfiles")).click();
				
		driver.close();
		Thread.sleep(5000);
		File f = new File(downloadPath + "/A.pdf");
		if(f.exists())
		{
			Assert.assertTrue(f.exists());
			if(f.delete())
				System.out.println("File Deleted");			
		}	
	}
}
