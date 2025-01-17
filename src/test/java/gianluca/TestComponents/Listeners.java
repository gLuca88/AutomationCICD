package gianluca.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import gianluca.resources.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		                        //esecuzione metodo  e poi prendiamo il nome del metodo
		extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.get().log(Status.PASS, "Test Ok");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		//test.log(Status.FAIL, "test Fallito");
		extentTest.get().fail(result.getThrowable());// ci ritorna il messaggio di errore
		
		
         //recuperiamo il driver del testo dlla varoabile result per usare lo stesso driver usato nei test per lo screnshot in caaso di errore
		 try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {//eccezione generale
			e1.printStackTrace();
		} 
		///////////////////////////////////////////////////////////////
		// faccaimo lo scren shot e lo attacchiamo al report metodo in baseTest
        String filePath=null;
		try {
			filePath=getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}

}// close class
