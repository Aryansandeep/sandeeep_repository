package mobile;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Calculator_ARD {

	public static void main(String[] args) throws IOException {
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
		try
		{
			//Automate app screen elements
			driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
			String x=driver.getCurrentPackage();
			System.out.println(x);
			String y=driver.currentActivity();
			System.out.println(y);
			//Send app to background for 10 seconds
			Duration d=Duration.of(10,ChronoUnit.SECONDS);
			driver.runAppInBackground(d);
			//Go To Home
			driver.pressKeyCode(AndroidKeyCode.HOME);
			//Activat Calculator
			driver.launchApp();
			//operate an element and Reset app
			driver.findElement(By.xpath("//[@ text='9']")).click();
			driver.resetApp();
			//close App
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//Stop and close Appium Server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}


