package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtils {

    public  String captureScreenshot(WebDriver driver, String screenshotName) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = System.getProperty("user.dir") + File.separator + 
                                "reports" + File.separator + "screenshots" + File.separator +
                                screenshotName + "_" + timeStamp + ".png";
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenshotPath);
            destFile.getParentFile().mkdirs(); // ensure folder exists
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            System.out.println("❌ Failed to capture screenshot: " + e.getMessage());
        }
        return screenshotPath;
    }
}
