package TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SampleClass {

	@BeforeClass
	public void BeforeClassMethod() {
		System.out.println("Before Class method Executed");
	}

	@BeforeMethod
	public void BeforeMethodMethod() {
		System.out.println("Before Method method Executed");
	}

	@BeforeTest
	public void BeforeTestMethod() {
		System.out.println("Before Test method Executed");
	}

	@Test
	public void FirstTestMethod() {
		System.out.println("First Test method Executed");
	}

	@Test(dataProvider = "getTestData")
	public void SecondTestMethod(String title, String firstName, String lastName, String company) {
		System.out.println("Second Test method Executed");
		System.out.println(title + " " + firstName + lastName + " is working in " + company);
	}

	@Test
	public void ThirdTestMethod() {
		System.out.println("Third Test method Executed");
	}

	@Test(dataProvider="getTestData")
	public void FourthTestMethod(String title, String firstName, String lastName, String company) {
		System.out.println("Fourth Test method Executed");
		System.out.println(title + " " + firstName + lastName + " is working in " + company);
	}
	
	@Test
	public void LinkedListMethod()
	{
		List<Integer> intList = new LinkedList<Integer>();
		intList.add(5);
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(3);
		System.out.println("Test: "+intList.get(2));
		for(int i=0; i<intList.size(); i++)
		{
		System.out.println(intList.get(i));
		}
	}
	
	@Test
	public void ArrayListMethod()
	{
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(5);
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(3);
		for(int i=0; i<intList.size(); i++)
		{
		System.out.println(intList.get(i));
		}
	}
	
	@Test
	public void HashSetMethod()
	{
		Set<Integer> intSet = new HashSet<Integer>();
		intSet.add(5);
		intSet.add(1);
		intSet.add(2);
		intSet.add(3);
		intSet.add(3);
		for(int i=0; i<intSet.size(); i++)
		{
		System.out.println(intSet);
		}
//		Iterator value = intSet.iterator();
//		while(value.hasNext())
//			{
//			System.out.println(intSet.iterator().next());
//			}
	}
	
	@Test
	public void LinkedHashSetMethod()
	{
		Set<Integer> intSet = new LinkedHashSet<Integer>();
		intSet.add(5);
		intSet.add(1);
		intSet.add(2);
		intSet.add(3);
		intSet.add(3);
		for(int i=0; i<intSet.size(); i++)
		{
		System.out.println(intSet);
		}
	}
	
	@Test
	public void TreeSetMethod()
	{
		Set<Integer> intSet = new TreeSet<Integer>();
		intSet.add(5);
		intSet.add(1);
		intSet.add(100);
		intSet.add(2);
		intSet.add(3);
		intSet.add(3);
		for(int i=0; i<intSet.size(); i++)
		{
		System.out.println(intSet);
		}
	}
	
	@Test
	public void HashMapMethod()
	{
		Map<String, String> stringMap = new HashMap<String, String>();
		stringMap.put("Name", "Ragurajan");
		stringMap.put("City", "Chennai");
		stringMap.put("Country", "India");
		System.out.println(stringMap.get("City"));
	}
	
	@Test
	public void LinkedHashMapMethod()
	{
		Map<String, String> stringMap = new LinkedHashMap<String, String>();
		stringMap.put("Name", "Ragurajan");
		stringMap.put("City", "Chennai");
		stringMap.put("Country", "India");
		System.out.println(stringMap.get("City"));
	}
	
	@Test
	public void TreeMapMethod()
	{
		Map<String, String> stringMap = new TreeMap<String, String>();
		stringMap.put("Name", "Ragurajan");
		stringMap.put("City", "Chennai");
		stringMap.put("Country", "India");
		System.out.println(stringMap.get("City"));
	}
	@BeforeSuite
	public void BeforeSuiteMethod() {
		System.out.println("Before Suite method Executed");
	}

	@DataProvider
	public static Object[][] getTestData() throws IOException {
		Object data[][] = getExcelSheetData();
		System.out.println("Reading 1 & 1 of data object: " + data[1][1]);
		// Object data[][] = { { "Ragu", "Rajan" }, { "Naga", "Rajan" }, { "Guru",
		// "Rajan" } };
		return data;
	}

	static String CurrPath = System.getProperty("user.dir");
	static String excelFilePath = CurrPath + "//FreeCrmTestData.xlsx";
	static String sheetName = "contacts";

	public static Object[][] getExcelSheetData() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(excelFilePath);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet(sheetName);
		Object[][] data = new Object[ws.getLastRowNum()][ws.getRow(0).getLastCellNum()];
		for (int i = 0; i < ws.getLastRowNum(); i++) {
			for (int j = 0; j < ws.getRow(0).getLastCellNum(); j++) {
				data[i][j] = ws.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}

}
