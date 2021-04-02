package appiumproject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;

public class EmailAutomate {

	static AppiumDriver<MobileElement> driver;
	public static void main(String[] args) throws Exception {
		
		
		openEmailApp();
	}

	public static void openEmailApp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","KB2001" );
		capabilities.setCapability("udid", "6a0dcc3c");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11");
		
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("autoGrantPermission", true);
		
		capabilities.setCapability("appPackage","com.fastsigninemail.securemail.bestemail");
		//capabilities.setCapability("appActivity","com.fastsigninemail.securemail.bestemail.ui.main.MainActivity");
		capabilities.setCapability("appActivity","com.fastsigninemail.securemail.bestemail.splash.SplashActivity");
		URL url = new URL("http:\\127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,capabilities);
		
		System.out.println("app is started");
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("close-button")));
//		
		
		String senderMailid="Prashanth.ravi@anywhere.co";
		MobileElement app =driver.findElement(By.id("close-button"));
		MobileElement appnav =driver.findElement(By.xpath("//android.view.View[@resource-id='close-button']"));
		appnav.click();
		
		driver.wait(2000);

		MobileElement composeMail = driver.findElement(By.xpath("(//android.widget.ImageButton)[3]"));
		composeMail.click();
		
		MobileElement To =driver.findElement(By.id("tv_title"));
		To.isDisplayed();
		MobileElement ToEmail =driver.findElement((By.id("token_complete_view")));
		ToEmail.sendKeys(senderMailid);
		
		MobileElement subject =driver.findElement((By.id("edt_subject")));
		subject.sendKeys("Automation");
		
		MobileElement bodyText =driver.findElement((By.id("edt_compose_mail")));
		bodyText.sendKeys("Hi this an automation email");
		
		MobileElement backButton =driver.findElement((By.id("Navigate up")));
		backButton.click();
		
		MobileElement saveAsDraft = driver.findElement((By.id("alertTitle"))); 
		saveAsDraft.isDisplayed();
		
		
		MobileElement yesButton = driver.findElement((By.id("button1")));
		yesButton.click();
		
		MobileElement later = driver.findElement((By.id("btn_later")));
		later.click();
		
		driver.closeApp();
		
		// waiting for 30 seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.resetApp();
		
		driver.wait(2000);
		
		//navigating back to app
		appnav.click();
		
		driver.wait(2000);
		
		MobileElement menu = driver.findElement(By.xpath("(//android.widget.ImageButton)[1]"));
		menu.click();
		
		MobileElement drafts = driver.findElement(By.xpath("//android.widget.TextView[@Text='Drafts')"));
		drafts.click();
		
		MobileElement draftsmail = driver.findElement(By.xpath("//android.widget.TextView[@Text='" + senderMailid +"')"));
		draftsmail.click();
		
		MobileElement ccNav = driver.findElement(By.id("img_dropdown"));
		ccNav.click();
		
		
		MobileElement ccMail = driver.findElement(By.xpath("//android.widget.MultiAutoCompleteTextView"));
		ccMail.sendKeys("vignesh.mariappan@anywhere.co");
		
		
		MobileElement sendMail = driver.findElement(By.id("action_send"));
		sendMail.click();
	}
	
	
}
