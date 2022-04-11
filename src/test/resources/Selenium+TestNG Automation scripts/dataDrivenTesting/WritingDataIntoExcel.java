package dataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file=new FileOutputStream("C://SeleniumPractice/testingdata.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("data");
		
		for(int i=0;i<=5;i++) //rows
		{
			XSSFRow row=sheet.createRow(i);
			
			for(int j=0;j<3;j++) //cells/columns
			{
			row.createCell(j).setCellValue("abcedfg");
			}
		}

		
		workbook.write(file);
		
		System.out.println("writing excel is completed");
		
	}

}
