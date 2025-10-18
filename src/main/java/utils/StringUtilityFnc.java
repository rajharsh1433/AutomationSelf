package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StringUtilityFnc {
	
	WebDriver driver;
	
	public StringUtilityFnc(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//function to get the names of all the items present in a list.
	public List<String> getlist(By addr2){
		  List<String> LIST = driver.findElements(addr2)
                  .stream()
                  .map(WebElement::getText)
                  .toList();
		  return LIST;
		
	}

}
