package mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

public class Opera {

	public static void main(String[] args) throws SikuliException {
		 System.setProperty("webdriver.opera.driver","E:\\Batch238\\operadriver_win64\\operadriver.exe");
		 
			OperaOptions op = new OperaOptions();
		    op.setBinary("C:\\Program Files\\Opera\\53.0.2907.68\\opera.exe");
		    OperaDriver driver = new OperaDriver(op);
		    driver.get("https://www.youtube.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(100, java.util.concurrent.TimeUnit.SECONDS);
			//Search for a video 
			WebDriverWait w=new WebDriverWait(driver,100);
		    w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search']")));
			driver.findElement(By.xpath("//*[@aria-label='Search']")).sendKeys("need for speed");
			driver.findElement(By.xpath("//*[@id='search-icon-legacy']")).click();
			driver.findElement(By.xpath("//*[@id='title-wrapper']/descendant::a[1]")).click();
			//Video Automation using Sikuli
			Screen s=new Screen();
			 //movie mouse pointer to video body
			org.sikuli.script.Location l=new org.sikuli.script.Location(751,521);
			s.wheel(l,Button.LEFT,0);
			s.click("YT_maximize.png");
			
			

	}

}
