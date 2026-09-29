package SE.ChangeCokpitAutomation.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportExtent {

	
	public static ExtentReports getReportObject()
	{
		String path =System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Change Cockpit Automation Results");
		reporter.config().setDocumentTitle("Change Cockpit Test Results");
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Mariyam Zaidi");
		return extent;
		
		
		
	}
	
	
	
}
