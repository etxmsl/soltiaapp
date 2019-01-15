package soltiaapp.se;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StartPage extends IPageChrome {
	public StartPage(int defaultwait) {
		   super(defaultwait);
		   // TODO Auto-generated constructor stub
		   driver.get("http://teltecstaging.nu/soltiaapp.se");
	}


	
	public void loadpage(){
		   driver.get("http://teltecstaging.nu/soltiaapp.se");
	}
	
 public boolean findInputByIdandsendkeys(String id,String keys){
 	   boolean success=true;
 	   WebElement idelement=driver.findElement(By.tagName("html"));
 	   try{
 		   idelement=driver.findElement(By.id(id));
 	   } catch(Exception e){
 		   success=false;
 	   }
 	   if(success){idelement.sendKeys(keys);}
 	      
 	   return success;
 }
 
 public boolean findElementBycssandclick(String css){
 	   boolean success=true;
 	   WebElement csselement=driver.findElement(By.tagName("html"));
 	   try{
 		   csselement=driver.findElement(By.cssSelector(css));
 	   } catch(Exception e){
 		   success=false;
 	   }
 	   if(success){csselement.click();}
 	      
 	   return success;
	   
 }
 public boolean findElementByidandclick(String id){
	   boolean success=true;
	   WebElement idelement=driver.findElement(By.tagName("html"));
	   try{
		   idelement=driver.findElement(By.id(id));
	   } catch(Exception e){
		   success=false;
	   }
	   if(success){idelement.click();}
	      
	   return success;
	   
}

 
 public boolean findElementBynameandclick(String name){
	   boolean success=true;
	   WebElement namelement=driver.findElement(By.tagName("html"));
	   try{
		   namelement=driver.findElement(By.name(name));
	   } catch(Exception e){
		   success=false;
	   }
	   if(success){namelement.click();}
	      
	   return success;
	   
}
 public boolean findElementByxpathandclick(String xpath){
	   boolean success=true;
	   WebElement csselement=driver.findElement(By.tagName("html"));
	   try{
		   csselement=driver.findElement(By.xpath(xpath));
	   } catch(Exception e){
		   success=false;
	   }
	   if(success){csselement.click();}
	      
	   return success;
	   
}
 public boolean findandClicCheckboxbyid(String id){
 	   boolean success=true;
 	   WebElement idelement=driver.findElement(By.tagName("html"));
 	   try{
 		   idelement=driver.findElement(By.id(id));
 	   } catch(Exception e){
 		   success=false;
 	   }
 	   if(success){idelement.click();}
 	      
 	   return success;
	
 }
 
 public String getTextByWebElement (WebElement element){
 	   return element.getText();
 }
 
 public List<WebElement> getWebElementsByCss(String css){
 	   List<WebElement> ret = driver.findElements(By.cssSelector(css));
 	   return ret;
 }
 public List<WebElement> getWebElementsByXpath(String xpath){
	   List<WebElement> ret = driver.findElements(By.xpath(xpath));
	   return ret;
}
}
