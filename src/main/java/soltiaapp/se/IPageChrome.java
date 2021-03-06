package soltiaapp.se;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IPageChrome {
	protected static WebDriver driver;
	WebDriverWait wait;
	
	public IPageChrome(int defaultwait){
	    ChromeOptions chromeOptions = new ChromeOptions();
	    //chromeOptions.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
	    chromeOptions.addArguments("--headless");
	    chromeOptions.addArguments("window-size=1500x720");

		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		if (driver == null){
		 driver=new ChromeDriver(chromeOptions);
		}
		wait = new WebDriverWait(driver, defaultwait);
	}

	public static WebDriver startDriver(){
	    ChromeOptions chromeOptions = new ChromeOptions();
	    //chromeOptions.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
	    chromeOptions.addArguments("--headless");
	    chromeOptions.addArguments("window-size=1500x720");
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		driver=new ChromeDriver();
		return driver;
	}
    public static void killDriver(WebDriver driv){
    		driv.close();
    		driv.quit();
    	    	
    }
    
	public boolean waitForVisabilitybyxpath(String xpath){
		boolean visible=true;
		try {
			driver.findElement(By.xpath(xpath));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	        //wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		}catch(Exception e){
			visible=false;
		}
		return visible;
	}
	
	public boolean waitForVisabilitybycss(String css){
		boolean visible=true;
		try{
			driver.findElement(By.cssSelector(css));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
	        //wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		}catch(Exception e){
			visible=false;
		}
		return visible;
	}
	
	public boolean waitForVisabilitybyclass(String class1){
		boolean visible=true;
		try{
			driver.findElement(By.className(class1));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(class1)));
	        //wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		}catch(Exception e){
			visible=false;
		}
		return visible;
	}
	
	public boolean waitForVisabilitybyid(String id){
		boolean visible=true;
		try{
			driver.findElement(By.id(id));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	        //wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		}catch(Exception e){
			visible=false;
		}
		return visible;
	}
	
	public boolean waitForVisabilitybylink(String linkText){
		boolean visible=true;
		try{
			driver.findElement(By.linkText(linkText));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
	        //wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		}catch(Exception e){
			visible=false;
		}
		return visible;
	}

}
