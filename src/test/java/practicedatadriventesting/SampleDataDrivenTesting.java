package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
        //	 Step 1:get the java representation object of the physical file
		FileInputStream fs=new FileInputStream("C:\\Users\\G Bhavyasri\\OneDrive\\Desktop\\commondata.properties");
		
		
        //   Step 2: Using properties class, load all the keys
		
		Properties prop=new Properties();
		prop.load(fs);//if we do not load the file in to the Properties Class and trying to get the property of object we will get null value
		
        //Step 3: get the value based on key        		
       System.out.println(prop.getProperty("url"));
	}

}
