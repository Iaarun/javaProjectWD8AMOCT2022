package testNgListenersPackage;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListners implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" STARTED");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" SUCCESS");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+"FAILED");
	}

}
