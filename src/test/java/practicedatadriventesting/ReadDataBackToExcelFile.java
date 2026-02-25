package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackToExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
       FileInputStream fs=new FileInputStream("C:\\\\Users\\\\G Bhavyasri\\\\OneDrive\\\\Desktop\\\\data\\\\TestData.xlsx");	
       
     Workbook book=  WorkbookFactory.create(fs);
     
     Sheet sheet= book.getSheet("Sheet1");
     
     Row row=sheet.getRow(1);
     
     Cell cell=row.createCell(5);
     
     cell.setCellType(CellType.STRING);
     cell.setCellValue("FAIL");
     
     FileOutputStream fos=new FileOutputStream("C:\\Users\\G Bhavyasri\\OneDrive\\Desktop\\data\\TestData.xlsx");
     book.write(fos);
     book.close();
     System.err.println("!!!!!!!!!!Executed!!!!");
     
     
     
     
	}

}
