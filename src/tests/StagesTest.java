package tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelexportandfileio.ReadGuru99ExcelFile;
import pages.HomePage;
import pages.stages.StagesPage;
import utility.ExcelUtils;

public class StagesTest {

	private String sTestCaseName;
	private int iTestCaseRow;
	

	@DataProvider

	public Object[][] StageCreation() throws Exception{

		// Setting up the Test Data Excel file
		ExcelUtils.setExcelFile("C://Users//Yesica Acha//workspace//JagdPanther//src//testdata//TestData.xlsx","StageData");

		sTestCaseName = this.toString();
		// From above method we get long test case name including package and class name etc.
		// The below method will refine your test case name, exactly the name use have used

		sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
		// Fetching the Test Case row number from the Test Data Sheet
		// Getting the Test Case name to get the TestCase row from the Test Data Excel sheet

		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
		
		Object[][] testObjArray = ExcelUtils.getTableArray("C://Users//Yesica Acha//workspace//JagdPanther//src//testdata//TestData.xlsx","StageData",iTestCaseRow);
		return (testObjArray);
	}

	@DataProvider(name="StageDataTxt")
    public Object[][] data() throws Exception {
        HashMap<String,String[]> dataSet= new Text2TestData("C:\\Users\\Yesica Acha\\workspace\\JagdPanther\\src\\testdata\\config.txt").getData();
        String search1Strings[]=dataSet.get("search1");
        String search2Strings[]=dataSet.get("search2");
        int size =search1Strings.length;
   
        // modify 2 upon the no. of rows; Here, I used two rows, 'search1' & 'search2'
        Object[][] creds = new Object[size][2];  
        for(int i=0;i<size;i++)
        {
            creds[i][0]=search1Strings[i];
            creds[i][1]=search2Strings[i];
        }
        return creds;
    }
	
	@DataProvider(name = "StageDataXlsx")
	public Object[][] stageData() throws IOException {
		
		//Create a object of ReadGuru99ExcelFile class
		ReadGuru99ExcelFile objExcelFile = new ReadGuru99ExcelFile();

		//Prepare the path of excel file
		String filePath = "C:\\Users\\Yesica Acha\\workspace\\JagdPanther\\src\\excelexportandfileio";

		//Call read file method of the class to read data
		return objExcelFile.readExcel(filePath,"ExportExcel.xlsx","ExcelGuru99Demo");
		
	}

	@Test (dataProvider = "StageDataXlsx")
	public void verifyNewStageIsCreated(String stageName, String stageTitle) throws Exception{

		//		String stageName = "StageName13";
		//		String stageTitle = "StageTitle1";
		//String stageDescription = "StageDescription1";
		//String stageType = "NORMAL";

		//Create Home Page object
		HomePage HomePage = new HomePage();
		StagesPage jagdPantherStagesPage = new StagesPage();

		//Create new Stage
		HomePage
		.clickStagesLink()
		.clickNewStageButton()
		.setStageTitle(stageTitle)
		.setStageName(stageName)
		.clickSaveButton();
		Assert.assertTrue(jagdPantherStagesPage.getStageName().contains(stageName));
		//System.out.print(jagdPantherStagesPage.getStageName());

	}
}
