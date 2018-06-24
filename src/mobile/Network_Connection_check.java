package mobile;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

public class Network_Connection_check {

	public static void main(String[] args) throws IOException {
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
		// Get address of Appium Server
		URL u= new URL ("http://127.0.0.1:4723/wd/hub");
		// Provide device and App Details
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","Mi A1");
		dc.setCapability("platformVersion","8.0.0");
		dc.setCapability("platformName","android");
		dc.setCapability("appPackage","com.google.android.apps.messaging");
		dc.setCapability("appActivity","com.google.android.apps.messaging.ui.ConversationListActivity");
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
		//Check Network Connection Options
		Connection c=driver.getConnection();
		if(c.compareTo(Connection.AIRPLANE)==0);
		{
			System.out.println("AIRPLANE is ON");
		}
	//	else
		{
			System.out.println("AIRPLANE is OFF");
		}
		if(c.compareTo(Connection.DATA)==0);
		{
			System.out.println("DATA is ON");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		

	}

}
