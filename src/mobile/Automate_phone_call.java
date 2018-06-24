package mobile;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Automate_phone_call {

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
		//Automate aap screen elements
		try
		{
			driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
			String x="9826404037";
			for (int i=0; i<x.length(); i++)
			{
				char y=x.charAt(i);
			String z="";
			switch(y)
			{
		/*	case'0'
			z="zero";
			break;
			
			case '1' ;
			z="one";
			break;
			
			case '2'
			z="two";
			break;
			
			case 3 ;
			z="three";
			break;
			
			case '4' ;
			z="four";
			break;
			
			case '5' ;
			z="five";
			break;
			
			case '6' ;
			z="six";
			break;
			
			case '7' ;
			z="seven";
			break;
			
			case '8' ;
			z="eight";
			break;
			
			case '9' ;
			z="nine";
			break;
			*/
			}
		}
}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		}
}
