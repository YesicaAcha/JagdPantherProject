package framework.utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

/**
 * DataProviders for JagdPanher tests
 * @author Yesica Acha
 *
 */
public class DataProviderClass {
	
	/**
	 * This method return an Object with data to create Programs
	 * @return
	 */
	@DataProvider(name = "ProgramCreation")
	public static Object[][] programData() {
		return new Object[][] {{"ProgramName2A","ProgramTitle2","ProgramDescription2"},
							   {"ProgramName3A","ProgramTitle3","ProgramDescription3"}};
	}
	
	/**
	 * This method return an Object with data to create Users
	 * @return
	 */
	@DataProvider(name = "UserData")
	public static Object[][] userData() {
		return new Object[][] {{"98764554","Carlos","Guevara","csdom@comp.com"},
							   {"98464531","Eliana","Naviaj","csafdom@coafmp.com"}};
	}
	
	/**
	 * This method return an Object with data to create Stages
	 * @return
	 * @throws IOException
	 */
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
