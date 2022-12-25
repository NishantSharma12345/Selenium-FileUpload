package Automation.FileUpload;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUploadRobotAndStringSelectionClass 
{
	/**
	 * 
	 * This method will set any parameter string to the system's clipboard.
	 * 
	 */
	public static void setClipboardData(String string) 
	{
		//StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
	
	/**
	 * 
	 * Upload the image from local system
	 * 
	 */
	public static void uploadFile(String fileLocation) 
	{
		try 
		{
			// Setting ClipBoard with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} 
		catch (Exception exp) 
		{
			exp.printStackTrace();
		}
	}
	
    String URL = "https://www.ilovepdf.com/pdf_to_jpg";
	
	@Test
	public void testUpload() throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		WebElement element = driver.findElement(By.id("pickfiles"));
		element.click();
		uploadFile("//home//users//nishant.sharma//Downloads//demousers.pdf");
		Thread.sleep(2000);
	}
	
}
