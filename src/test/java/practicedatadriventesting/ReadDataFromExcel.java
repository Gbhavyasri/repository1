package practicedatadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
//        Step 1: Get the Excel path location & java Object of the physical ExcelFile
		  String path="‪C:\\Users\\G Bhavyasri\\OneDrive\\Desktop\\data\\TestData.xlsx";
		  
		  FileInputStream fs=new FileInputStream("C:\\Users\\G Bhavyasri\\OneDrive\\Desktop\\data\\TestData.xlsx");
		
//		Step2: Open Workbook in the read mode
		  
		Workbook book=  WorkbookFactory.create(fs);
		
		
//		step 3:get the control of the "org" sheet
		
		Sheet sheet=  book.getSheet("org");
		
		
//		step 4: get the control of the "1st" row
		Row row=sheet.getRow(9);
//		Step 5: get the control of the "2nd" cell and read the String data
		     Cell cell=row.getCell(3);
		     String data=cell.getStringCellValue();
		     System.out.println(data);
		     
		     Cell cell2=row.getCell(3);
		   double num=  cell2.getNumericCellValue();
		   System.out.println(num);
//		Step 6: Close the Workbook
		     book.close();
	}

}
