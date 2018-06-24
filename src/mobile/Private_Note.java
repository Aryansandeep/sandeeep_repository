package mobile;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Private_Note {

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
		
		Duration d=Duration.of(10,ChronoUnit.SECONDS);
		driver.pressKeyCode(AndroidKeyCode.HOME);
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Private Notes']")));
		driver.findElement(By.xpath("//*[@content-desc='Private Notes']")).click();
		//Swipe Pattern 
		int x1=(int)(541);
		int y1=(int)(856);
		int x2=(int)(900);
		int y2=(int)(863);
		TouchAction ta=new TouchAction(driver);
		ta.press(x1,y1).moveTo(x2-x1,y2-y1).waitAction(d).release().perform();
		

		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		
		

	}

}
