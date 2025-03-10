package demo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
	
	@Override
	public void onStart(ITestContext contextStart) {
		System.out.println("On start.....");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case pass "+result.getName());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case fail "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case fail "+result.getName());
	}
	@Override
	public void onFinish(ITestContext contextStart) {
		System.out.println("on Finish .....");
	}

}
