package practicedatadriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromTheJsonFile {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
//		Step 1: Parse json physical file in to java object using JsonParser Class
		 JSONParser parser=new JSONParser();
		Object obj= parser.parse(new FileReader("C:\\Users\\G Bhavyasri\\OneDrive\\Desktop\\data\\appCommonData.json"));
		
//		Step 2: Convert java object to the JSONObject using downCasting
		JSONObject map=(JSONObject)obj;
//		Step 3: get the value from the json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeOut"));
		 

	}

}
