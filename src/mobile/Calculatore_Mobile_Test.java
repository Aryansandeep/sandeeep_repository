package mobile;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Calculatore_Mobile_Test {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Get Data from keyBoard
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter Input one");
		String x=sc.nextLine();
		System.out.println("Enter Input two");
		String y=sc.nextLine();
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
		// Get address of Appium Server
		URL u= new URL ("http://127.0.0.1:4723/wd/hub");
		// Provide device and App Details
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","Emulator-mi:5554");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("platformName","android");
		dc.setCapability("appPackage","com.android.calculator2");
		dc.setCapability("appActivity","com.android.calculator2.Calculator");
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
		driver.findElement(By.xpath("//*[@class='android.widget.TextView']")).click();
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*//*[@text='\"+z+\"']")));
		//Enter Input one
		for (int i=0; i<x.length(); i++)
		{
			char z=x.charAt(i);
			driver.findElement(By.xpath("//*[@text='"+z+"']")).click();
		}
		Thread.sleep(5000);
		//Click Pluse
		driver.findElement(By.xpath("//*[@content-desc='pluse']")).click();
		//Enter Input two
		for (int i=0; i<y.length(); i++)
		{
			char z=y.charAt(i);
			driver.findElement(By.xpath("//*[@text='"+z+"']")).click();
		}
		Thread.sleep(5000);
		//Click Equals
		driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
		Thread.sleep(5000);
		//Get output
		String r=driver.findElement(By.xpath("//*[@android.widget.EditText]")).getAttribute("text");
		int i1=Integer.parseInt(x);
		int i2=Integer.parseInt(y);
		int o=Integer.parseInt(r);
		if(0==i1+i2)
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		Thread.sleep(3000);
		//Close App
		driver.closeApp();
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(5000);
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		
	}
}

