package SE.ChangeCokpitAutomation.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SE.ChangeCokpitAutomation.Reports.ReportExtent;
import SE.ChangeCokpitAutomation.utils.EmailUtils;

public class Listeners extends BaseTest implements ITestListener {

	ExtentReports extent = ReportExtent.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // Thread safe
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	/**
	 * Invoked each time a test succeeds.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SUCCESS
	 */
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	/**
	 * Invoked each time a test fails.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#FAILURE
	 */
	

	/**
	 * Invoked each time a test is skipped.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SKIP
	 */
	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	/**
	 * Invoked each time a method fails but has been annotated with
	 * successPercentage and this failure still keeps it within the success
	 * percentage requested.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	 */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	/**
	 * Invoked each time a test fails due to a timeout.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 */

	/**
	 * Invoked before running all the test methods belonging to the classes inside
	 * the &lt;test&gt; tag and calling all their Configuration methods.
	 *
	 * @param context The test context
	 */
	@Override
	public void onTestFailedWithTimeout(
	        ITestResult result) {

	    onTestFailure(result);
	}
	
	public void onStart(ITestContext context) {
		// not implemented
	}

	/**
	 * Invoked after all the test methods belonging to the classes inside the
	 * &lt;test&gt; tag have run and all their Configuration methods have been
	 * called.
	 *
	 * @param context The test context
	 */
//	public void onFinish(ITestContext context) {
//		extent.flush();
//		System.out.println("Extent Report Flushed Successfully");
//	}
	
	
	@Override
	public void onFinish(ITestContext context) {

	    int total = context.getAllTestMethods().length;
	    int passed = context.getPassedTests().size();
	    int failed = context.getFailedTests().size();
	    int skipped = context.getSkippedTests().size();

	    double passRate = ((double) passed / total) * 100;

	    extent.setSystemInfo("Total Tests",
	            String.valueOf(total));

	    extent.setSystemInfo("Passed",
	            String.valueOf(passed));

	    extent.setSystemInfo("Failed",
	            String.valueOf(failed));

	    extent.setSystemInfo("Skipped",
	            String.valueOf(skipped));

	    extent.setSystemInfo("Pass Rate",
	            String.format("%.2f%%", passRate));

	    extent.flush();

	    System.out.println("Extent Report Flushed Successfully");
	}
	@Override
	public void onTestFailure(ITestResult result) {

	    extentTest.get().fail(result.getThrowable());

	    try {

	        driver = (WebDriver) result
	                .getTestClass()
	                .getRealClass()
	                .getField("driver")
	                .get(result.getInstance());

	    } catch (Exception e1) {

	        e1.printStackTrace();
	    }

	    String filePath = null;

	    try {

	        filePath = getScreenshot(
	                result.getMethod().getMethodName(),
	                driver);

	    } catch (IOException e) {

	        e.printStackTrace();
	    }

	    extentTest.get().addScreenCaptureFromPath(
		        filePath,
		        result.getMethod().getMethodName());

	    EmailUtils.sendFailureMail(
	            result.getMethod().getMethodName(),
	            result.getThrowable().toString());
	}

}
