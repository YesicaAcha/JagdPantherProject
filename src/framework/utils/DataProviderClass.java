package framework.utils;

import java.io.IOException;
import java.util.HashMap;

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
		return new Object[][] {{"98764554","ProgramTitle2","ProgramDescription2","csdom@comp.com"},
							   {"98464531","ProgramTitle3","ProgramDescription3","csafdom@coafmp.com"}};
	}
	
	@DataProvider(name="UserDataTxt")
    public static Object[][] data() throws Exception {
        HashMap<String,String[]> dataSet= new ReadTextFile("C:\\Users\\Yesica Acha\\workspace\\JagdPanther\\src\\framework\\utils\\testdata\\config.txt").getData();
        String search1Strings[]=dataSet.get("search1");
        String search2Strings[]=dataSet.get("search2");
        int size =search1Strings.length;
   
        Object[][] parameters = new Object[size][2];  
        for(int i=0;i<size;i++)
        {
        	parameters[i][0]=search1Strings[i];
        	parameters[i][1]=search2Strings[i];
        	        	
        }
        return parameters;
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
