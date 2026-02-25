package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		String arr="";
		FileInputStream fs=new FileInputStream("C:\\Users\\G Bhavyasri\\OneDrive\\Desktop\\data\\TestData.xlsx");
		Workbook book=WorkbookFactory.create(fs);
		String expectedTestId="tc_03";
		boolean flag=false;
		Sheet sheet=book.getSheet("Sheet1");
		
		int rowNum=sheet.getLastRowNum();
		
		
		for(int i=1;i<=rowNum;i++) {
			
			try {
			String id=sheet.getRow(i).getCell(0).toString();
			
			if(id.equals(expectedTestId)) {
				flag=true;
				int colNum=sheet.getRow(i).getLastCellNum();
				for(int j=0;j<colNum;j++) {
					System.out.print(sheet.getRow(i).getCell(j).toString()+" ");
				}
				System.out.println();
			}
			}
			catch(Exception e) {
//				System.out.println("Empty cell");
			}
		}
		if(!flag) {
			System.out.println("Data is not Available!!!!");
		}
		book.close();
		

	}

}
