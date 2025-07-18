package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path= ".\\testData\\SwingpayData.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);
		int totalrows=xlutil.getRowCount("Sheet1");
		int toatalcols=xlutil.getCellCount("Sheet1",1);
		
		String logindata[][] = new String[totalrows][toatalcols];
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<toatalcols;j++) {
				logindata[i-1][j]= xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}

}
