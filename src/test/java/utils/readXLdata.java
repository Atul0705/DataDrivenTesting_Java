package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;


public class readXLdata {


	@DataProvider(name="loginData")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		String excelSheetName =m.getName();
		File f = new File(System.getProperty("user.dir")+"//src//test//java//utils//loginData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);
		int totalrows =sheetName.getLastRowNum();
		System.out.println(totalrows);
		Row rowsCells = sheetName.getRow(0);
		int totalCols = rowsCells.getLastCellNum();
		System.out.println(totalCols);

		DataFormatter format = new DataFormatter();

		String testdata[][] = new String[totalrows][totalCols];

		for(int i=1;i<=totalrows;++i)
		{
			for(int j=0;j<totalCols;++j)
			{
				testdata[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testdata[i-1][j]);
			}
		}

		return testdata;

	}

}
