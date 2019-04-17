package alistairmcgann;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
/**
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
*/
public class Deck {
	private String filepath = new String();
	
	private static final Type CARD_TYPE = new TypeToken<List<Card>>(){}.getType();
	private List<Card> cards;
	
/**
	JSONParser parser = new JSONParser();
   	JSONArray cards = new JSONArray();
*/
   	Gson gson = new Gson();
   	
   	FileReader filereader;
   	JsonReader jsonreader;
   	
	public Deck() {
		
        filepath = "C:\\Users\\mcga\\git\\oh-my-goods\\oh-my-goods\\src\\main\\java\\alistairmcgann\\cards.json";
		 
        try {
			filereader = new FileReader(filepath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        
    	cards = new Gson().fromJson(filereader, CARD_TYPE);
    	
    	shuffle();

        //for (Card c:cards) {
        //	System.out.println( c );
        //}
       	
       	//System.out.println(((JSONObject) cards.get(0)).get("cost"));
       	
	}
	
	public void shuffle() {
		Collections.shuffle(this.cards);
	}
	
	public Card draw() {
		
		if (cards.isEmpty()) {
			throw new IllegalStateException("No cards left in deck");
		}
		
		int firstCard = cards.size() - 1;
		
		Card card = cards.get(firstCard);
		
		cards.remove(firstCard);
		
		return card;
	}
	
}
