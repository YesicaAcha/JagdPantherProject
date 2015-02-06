package framework.utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

/**
 * DataProviders for JagdPanher tests
 * @author Yesica Acha
 *
 */
public class DataProviderClass {
	
	@DataProvider(name = "ProgramCreation")
	public static Object[][] programData() {
		return new Object[][] {{"ProgramName2A","ProgramTitle2","ProgramDescription2"},
							   {"ProgramName3A","ProgramTitle3","ProgramDescription3"}};
	}
	
	@DataProvider(name = "UserData")
	public static Object[][] userData() {
		return new Object[][] {{"98764554","Carlos","Guevara","csdom@comp.com"},
							   {"98464531","Eliana","Naviaj","csafdom@coafmp.com"}};
	}
	
	@DataProvider(name = "StageDataXlsx")
	public static Object[][] stageData() throws IOException {
		
		//Create a object of ReadGuru99ExcelFile class
		ReadExcelFile objExcelFile = new ReadExcelFile();

		//Prepare the path of excel file
		String filePath = "C:\\Users\\Yesica Acha\\workspace\\JagdPanther\\src\\framework\\utils\\testdata";

		//Call read file method of the class to read data
		return objExcelFile.readExcel(filePath,"ExportExcel.xlsx","StageData");		
	}	
}
