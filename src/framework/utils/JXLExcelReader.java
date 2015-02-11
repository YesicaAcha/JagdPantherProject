package framework.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JXLExcelReader {
	
	private Workbook excelWorkbook;
	/**
	 * This method is used to read Excel file for external data
	 * @param filePath
	 * @param fileName
	 * @param sheetName
	 * @return List<Map<String, String>>
	 * @throws BiffException 
	 * @throws IOException
	 * @throws JXLException
	 */

	public JXLExcelReader(String filePath, String fileName) throws BiffException, IOException{
		File file = new File(filePath + "\\" + fileName);
		excelWorkbook = Workbook.getWorkbook(file);
	}
	public List<Map<String, String>> readExcel(String sheetName) throws IOException, JXLException {
		
		Sheet excelSheet = excelWorkbook.getSheet(sheetName);	
		String key;
		String value;
		List<Map<String, String>> listMap = new LinkedList<>();

		for (int j = 1; j < excelSheet.getRows(); j++) {
			Map<String, String> map = new HashMap<String, String>();
			for (int i = 0; i < excelSheet.getColumns(); i++) {		
				key = excelSheet.getCell(i,0).getContents();
				value = excelSheet.getCell(i,j).getContents();
				map.put(key,value);	
			}
			listMap.add(map);
		}
		
		return listMap;    
	}

	/**
	 * This method is used to read an excel file for Data provider
	 * @param filePath
	 * @param fileName
	 * @param sheetName
	 * @return an Object[][]
	 * @throws IOException
	 * @throws JXLException
	 */
	public Object[][] readExcelDataProvider(String sheetName) throws IOException, JXLException {

		Sheet excelSheet = excelWorkbook.getSheet(sheetName);
		Object[][] data = new Object[excelSheet.getRows() - 1][excelSheet.getColumns()];

		for (int j = 0; j < excelSheet.getColumns(); j++) {
			for (int i = 1; i < excelSheet.getRows(); i++) {
				data[i - 1][j] = excelSheet.getCell(j, i).getContents();		
			}
		}
		return data;    
	}



}
