package mobile;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Openaap {

	public static void main(String[] args) throws IOException {
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe / k \"appium -a 127.0.0.1 -p 4723\"");
		// Get address of Appium Server
		URL u= new URL ("http://127.0.0.1:4723/wd/hub");
		// Provide device and app Details
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","mi 5554");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("platformName","android");
		dc.setCapability("appPackage"," com.android.deskclock");
		dc.setCapability("appActivity","com.android.deskclock.DeskClock");
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
		driver.findElement(By.xpath("android.view.View")).click();
		
	}
	
}

