package gianluca.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	

	public static ExtentReports getReportObject() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);// questo oggetto reporter è respnsabile della cerazione del report
		reporter.config().setReportName("Web Autoamtion Results Gianluca");
		reporter.config().setDocumentTitle("Gianluca Test result");

		ExtentReports extent = new ExtentReports();// la classe principale a cui legianmo il report estende i report
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester: ", "Gianluca");
		return extent;

	}//close method

}// close class
