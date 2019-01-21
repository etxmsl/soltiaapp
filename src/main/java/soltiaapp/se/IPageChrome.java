package soltiaapp.se;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IPageChrome {
	protected static WebDriver driver;
	WebDriverWait wait;
	
	public IPageChrome(int defaultwait){
	    ChromeOptions chromeOptions = new ChromeOptions();
	    //chromeOptions.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
	    chromeOptions.addArguments("--headless");

		System.setProperty("webdriver.chrome.driver", "/home/martin/Selenium/chromedriver");
		if (driver == null){
		 driver=new ChromeDriver(chromeOptions);
		}
		wait = new WebDriverWait(driver, defaultwait);
	}

	public static void startDriver(){
		System.setProperty("webdriver.chrome.driver", "/home/martin/Selenium/chromedriver");
		driver=new ChromeDriver();
	}
    public static void killDriver(){
    	if(driver != null){
    		driver.close();
    	}
    	    	
    }
    
	public boolean waitForVisabilitybyxpath(String xpath){
		boolean visible=true;
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	        wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		}catch(Exception e){
			visible=false;
		}
		return visible;
	}
	
	public boolean waitForVisabilitybycss(String css){
		boolean visible=true;
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
	        wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		}catch(Exception e){
			visible=false;
		}
		return visible;
	}
	
	public boolean waitForVisabilitybyclass(String class1){
		boolean visible=true;
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(class1)));
	        wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		}catch(Exception e){
			visible=false;
		}
		return visible;
	}
	
	public boolean waitForVisabilitybyid(String id){
		boolean visible=true;
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	        wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		}catch(Exception e){
			visible=false;
		}
		return visible;
	}
	
	public boolean waitForVisabilitybylink(String linkText){
		boolean visible=true;
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
	        wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		}catch(Exception e){
			visible=false;
		}
		return visible;
	}

}
