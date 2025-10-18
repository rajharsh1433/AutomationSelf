package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static String reportFolder = System.getProperty("user.dir") + File.separator + "reports";
    private static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    private static String reportFileName = "ExtentReport-" + timeStamp + ".html";
    private static String reportFileLocation = reportFolder + File.separator + reportFileName;

    // synchronized to be safe in parallel runs
    public static synchronized  ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }
    private  static ExtentReports createInstance() {

        // ensure reports folder exists
        File reportsDir = new File(reportFolder);
        if (!reportsDir.exists()) {
            reportsDir.mkdirs();
        }

        ExtentSparkReporter spark = new ExtentSparkReporter(reportFileLocation);
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("Automation Test Report");
        spark.config().setReportName("My Project - Test Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        // optional system info
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("User", System.getProperty("user.name"));

        return extent;
    }

    // convenience flush method
    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }

    // useful if you want to print/open the location after run
    public  String getReportPath() {
        return reportFileLocation;
    }
}
