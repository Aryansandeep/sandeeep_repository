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
import io.appium.java_client.android.AndroidKeyCode;

public class Appium_server_details {

	public static void main(String[] args) throws IOException, InterruptedException {
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
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Go to Home
		driver.pressKeyCode(AndroidKeyCode.HOME);
		Thread.sleep(1000);
		//Get appium server address
		String x=driver.getRemoteAddress().getPath();
		System.out.println(x);
		//Get Protocol
		String y=driver.getRemoteAddress().getProtocol();
		System.out.println(y);
		//Get Port Number
		int z=driver.getRemoteAddress().getPort();
		System.out.println(z);
		//Get Host
		String h=driver.getRemoteAddress().getHost();
		System.out.println(h);
		//Get Display Density
		long d=driver.getDisplayDensity();
		System.out.println(d);
		//Get Device Time
		String t=driver.getDeviceTime();
		System.out.println(t);
		//Get Plateform Name
		String p=driver.getPlatformName();
		System.out.println(p);
		Thread.sleep(4000);
		//Get version Number of Android Name
		driver.openNotifications();
		WebDriverWait w=new WebDriverWait(driver,20);
	//	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@bounds='[736,228][880,372]']")));
		driver.findElement(By.xpath("//*[@bounds='[736,228][880,372]']")).click();
	//	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@bounds='[0,1704][1080,1920]']")));
		driver.findElement(By.xpath("//*[@bounds='[0,1704][1080,1920]']")).click();
	//	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@bounds='[216,1248][1032,1464]']")));
		driver.findElement(By.xpath("//*[@bounds='[216,1248][1032,1464]']")).click();
	//	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@bounds='[216,1248][1032,1464]']")));
		driver.findElement(By.xpath("//*[@bounds='[216,1248][1032,1464]']")).click();
		
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		
		
		
		
		
		
		
		
		
		

	}

}
