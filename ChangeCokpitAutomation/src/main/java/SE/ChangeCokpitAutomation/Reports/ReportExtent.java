package SE.ChangeCokpitAutomation.Reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportExtent {

    public static ExtentReports getReportObject() {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String path = System.getProperty("user.dir")
                + "//reports//ExtentReport_" + timeStamp + ".html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

        reporter.config().setReportName("Change Cockpit Automation Results");
        reporter.config().setDocumentTitle("Automation Execution Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Tester", "Swapnil Kedar");
        extent.setSystemInfo("Application", "Change Cockpit");
        extent.setSystemInfo("Environment", "Acceptance");
        extent.setSystemInfo("Browser", "Firefox");
        extent.setSystemInfo("Framework", "Selenium + TestNG");
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Execution", "Regression Suite");
        
        return extent;
    }
    
    
}