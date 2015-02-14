package framework.utils;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import jxl.JXLException;

public class ExternalData {
	
	public List<Map<String, String>> readExternalData(String sheetName) throws JXLException, IOException {		
//		String filePath = "C:\\Users\\Yesica Acha\\workspace\\JagdPanther\\src\\framework\\utils\\datasource";
		String filePath =  System.getProperty("user.dir") + "\\src\\framework\\utils\\datasource";
		//System.out.println(System.getProperty("user.dir"));
		String fileName = "ExternalData.xls";
		JXLExcelReader reader = new JXLExcelReader(filePath, fileName);
		return reader.readExcel(sheetName);
	}
	
	public List<Map<String, String>> readExternalStageData() throws JXLException, IOException {		
		return readExternalData("StageData");
	}
	
	public List<Map<String, String>> readExternalProgramData() throws JXLException, IOException {		
		return readExternalData("ProgramData");
	}
	
	public List<Map<String, String>> readExternalGroupData() throws JXLException, IOException {		
		return readExternalData("GroupsData");
	}
	
	public List<Map<String, String>> readExternalPeriodData() throws JXLException, IOException {		
		return readExternalData("PeriodData");
	}
	
	public List<Map<String, String>> readExternalApplicantsData() throws JXLException, IOException {		
		return readExternalData("ApplicantData");
	}
	
	public List<Map<String, String>> readExternalGradesData() throws JXLException, IOException {		
		return readExternalData("GradesData");
	}
	
	

}
