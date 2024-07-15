package gianluca.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
    
	
	int count=0;
	int maxTry=1;
	@Override
	public boolean retry(ITestResult result) {
		System.out.println("Test FALLITO!!!!");
		if(count<maxTry) 
		{
			count++;
			System.out.println("Test RIPETUTO!!!!");
			return true;
	
		}
		
		return false;
	}

}//close class
