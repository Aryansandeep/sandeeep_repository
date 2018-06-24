package mobile;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Clock_Test {

		public static void main(String[] args) throws IOException, InterruptedException {
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe / k \"appium -a 127.0.0.1 -p 4723\"");
			// Get address of Appium Server
			URL u= new URL ("http://127.0.0.1:4723/wd/hub");
			// Provide device and app Details
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,"");
			dc.setCapability("deviceName","Mi A1");
			dc.setCapability("platformVersion","8.0.0");
			dc.setCapability("platformName","android");
			dc.setCapability("appPackage"," com.google.android.deskclock");
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
			
			driver.findElement(By.xpath("//*[@class='android.widget.TextView']")).click();
			
			driver.findElement(By.xpath("//*[@content-desc='Start new conversation']")).click();
			
			driver.findElement(By.xpath("//*[@content-desc='Switch between entering text and numbers']")).click();
			
			//driver.findElement(By.xpath(""));
		/*	driver.findElement(By.xpath("//*[@class='android.widget.checkBox'])[4]")).click();
			driver.pressKeyCode(AndroidKeyCode.HOME);*/
			//stop appium server
			Runtime.getRuntime().exec("taskkill / F / IM node.exe");
			Runtime.getRuntime().exec("taskkill / F / IM cmd.exe"); 
		}
	
		


	}


