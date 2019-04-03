package alistairmcgann;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Deck {
	private String filepath = new String();
	
	JSONParser parser = new JSONParser();
   	JSONArray cards = new JSONArray();

	public Deck() {

        filepath = "C:\\Users\\mcga\\git\\oh-my-goods\\oh-my-goods\\src\\main\\java\\alistairmcgann\\cards.json";
		 
       	try {
			cards = (JSONArray) parser.parse(new FileReader(filepath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
       	System.out.println(cards.get(0));
       	
	}
	
}
