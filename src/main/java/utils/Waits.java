package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waits {

    private  final int DEFAULT_TIMEOUT = 20; // You can centralize this

    // Wait until element is visible (By locator)
    public  WebElement waitForVisibility(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait until element is visible (existing WebElement)
    public  WebElement waitForVisibility(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for all elements to be visible
    public  List<WebElement> waitForAllVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    // Wait until element is clickable
    public  WebElement waitForClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait for element to disappear
    public  boolean waitForInvisibility(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Wait for page to fully load (JS readyState)
    public  void waitForPageLoad(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete")
        );
    }
}
