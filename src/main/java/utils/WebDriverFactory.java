package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	
	//Thread local for parallel execution
	private static   ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/**
	 * Initalizing webdrivers based on names
	 */
	public static WebDriver initDriver(String browser) {
		System.out.println("Launching browsers: "+browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			tlDriver.set(new ChromeDriver(options));
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--start-maximized");
			tlDriver.set(new EdgeDriver(options));
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--start-maximized");
			tlDriver.set(new FirefoxDriver(options));
		}
		else {
			System.out.println("Incorrect browser name, starting with default chrome browser");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			tlDriver.set(new ChromeDriver(options));
		}
		System.out.println(tlDriver.get());
		return getDriver();
	}
	/*
	 * Get the driver for the current thread instance
	 */
	public static  WebDriver getDriver() {
		System.out.println(tlDriver);
		System.out.println(tlDriver.get());
		return tlDriver.get();
	}
	/**
	 * Quit the driver and remove it from thread loal
	 */
	public  static void quitDriver() {
		if(getDriver()!=null) {
			getDriver().quit();
			tlDriver.remove();
		}
	}
}
