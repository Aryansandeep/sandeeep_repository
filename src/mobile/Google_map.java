package mobile;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Google_map {

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
		dc.setCapability("locationServicesEnabled",true);
		dc.setCapability("locationServicesAuthorized",true);
		dc.setCapability("appPackage","com.google.android.apps.maps");
		dc.setCapability("appActivity","com.google.android.maps.MapsActivity");
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
		Thread.sleep(5000);
		//set location to Bangalaluru
		Location l1=new Location(12.9271599,77.594563,2000);
		driver.setLocation(l1);
		Thread.sleep(5000);
		//set location to Tajmahal
		Location l2=new Location(27.175015,78.042155,2000);
		driver.setLocation(l2);
		Thread.sleep(5000);
		driver.closeApp();
		Runtime.getRuntime().exec("taskkill / F / IM node.exe");
		Runtime.getRuntime().exec("taskkill / F / IM cmd.exe"); 

	}

}
