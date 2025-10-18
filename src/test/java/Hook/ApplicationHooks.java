package Hook;  // ⚠️ use lowercase for package names (Java convention)

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentReportManager;
import utils.ExtentTestManager;
import utils.ScreenShotUtils;
import utils.WebDriverFactory;

public class ApplicationHooks {

    private static WebDriver driver;
    private static ScreenShotUtils screenshotUtils = new ScreenShotUtils();
   // private ExtentReportManager erm = new ExtentReportManager();

    @Before
    public static void beforeScenario(Scenario scenario) {
        // Initialize driver
       
        WebDriverFactory.initDriver("chrome");
        driver = WebDriverFactory.getDriver();

        // Start Extent report test
        String testName = scenario.getName();
        ExtentTestManager.startTest(testName, "Starting scenario: " + testName);
        ExtentTestManager.getTest().log(Status.INFO, "Scenario started: " + testName);
    }

    @SuppressWarnings({ "static-access" })
	@After
    public static void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = screenshotUtils.captureScreenshot(driver, scenario.getName());
            ExtentTestManager.getTest().log(Status.FAIL, "Scenario failed: " + scenario.getName());
            try {
                ExtentTestManager.getTest()
                    .addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
            } catch (Exception e) {
                System.out.println("⚠️ Failed to attach screenshot: " + e.getMessage());
            }
        } else {
            ExtentTestManager.getTest().log(Status.PASS, "Scenario passed successfully");
        }

        // Flush report and close driver
        ExtentReportManager.flush();
        WebDriverFactory.quitDriver();
    }
   
}
