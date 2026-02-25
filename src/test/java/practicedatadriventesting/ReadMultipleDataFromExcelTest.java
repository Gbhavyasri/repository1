package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
      FileInputStream fs=new FileInputStream("C:\\Users\\G Bhavyasri\\OneDrive\\Desktop\\data\\TestScriptData.xlsx");
    Workbook book=  WorkbookFactory.create(fs);
    
   Sheet sheet= book.getSheet("Sheet1");
   int lastRow=sheet.getLastRowNum();
    Row row=sheet.getRow(1);
    int cellNum=row.getLastCellNum();
    String columnData1=row.getCell(0).toString();
    String columnData2=row.getCell(1).toString();
    
    for(int i=1;i<=lastRow;i++) {
    	for(int j=0;j<cellNum;j++) {
    		System.out.print(sheet.getRow(i).getCell(j).toString()+" ");
    	}
    	System.out.println();
    }
//    System.out.println(columnData1);
//    System.out.println(columnData2);
//      
	}

}
