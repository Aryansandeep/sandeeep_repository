package mobile;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.android.AndroidDriver;

public class Calling_Number {

	public static void main(String[] args) throws IOException, InterruptedException {
		
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
			// Get address of Appium Server
			URL u= new URL ("http://127.0.0.1:4723/wd/hub");
			// Provide device and app Details
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,"");
			dc.setCapability("deviceName","Mi A1");
			dc.setCapability("platformVersion","8.0.0");
			dc.setCapability("platformName","android");
			dc.setCapability("appPackage","com.google.android.dialer");
			dc.setCapability("appActivity","com.google.android.dialer.extensions.GoogleDialtactsActivity");
			//Create driver object to launch app in device
			AndroidDriver driver;
			while(2>1)
			{
				try
				{
					driver=new AndroidDriver(u,dc);
					break;
				}
				catch (Exception e)
				{
			    }
		  }
		//Automate app screen elements
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[content-desc='Phone']")).click();
	
			//WebDriverWait w=new WebDriverWait(driver,10);
			//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("com.google.android.dialer:id/floating_action_button")));
			//driver.findElement(By.xpath("//*[class='android.widget.ImageButton']")).click();
			//driver.findElement(By.id("com.google.android.dialer:id/nine")).click();
			
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
			
	}       

}
