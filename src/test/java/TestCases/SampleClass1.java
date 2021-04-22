package TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleClass1 {
	
	@Test(dataProvider = "getTestData")
	public void FirstTestMethod(String title, String firstName, String lastName, String company) {
		System.out.println("First Test method Executed");
		System.out.println(title + " " + firstName + lastName + " is working in " + company);
	}
	@DataProvider
	public Object[][] getTestData() throws IOException {
		Object data[][] = SampleClass.getTestData();
		return data;
	}
}
