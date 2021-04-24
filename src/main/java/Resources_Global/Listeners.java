package Resources_Global;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

public class Listeners extends base implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + " is Started!");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + " is Passed!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		  WebDriver driver =null; try { driver
		  =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").
		  get(result.getInstance()); takeSnapShot(result.getMethod().getMethodName(),
		  driver); } catch (Exception e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }
		 
		System.out.println(result.getName() + " is Failed!");

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
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(context.getName() + " is Started!");

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(context.getName() + " is Finished!");

	}

}
