package alistairmcgann;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
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
public class Deck extends CardCollection {
	private String filepath = new String();
	
	private static final Type CARD_TYPE = new TypeToken<CardCollection>(){}.getType();
	
/**
	JSONParser parser = new JSONParser();
   	JSONArray cards = new JSONArray();
*/
   	Gson gson = new Gson();
   	
   	FileReader filereader;
   	JsonReader jsonreader;
   	
   	public Deck(Collection<Card> inputCards) {
   		this.addAll(inputCards);// = inputCards;
   		//System.arraycopy(inputCards, 0, this.cards, 0, inputCards.size());
   	}
   	
	public Deck() {
		
        filepath = "C:\\Users\\mcga\\git\\oh-my-goods\\oh-my-goods\\src\\main\\java\\alistairmcgann\\cards.json";
		 
        try {
			filereader = new FileReader(filepath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    	CardCollection cards = new Gson().fromJson(filereader, CARD_TYPE);
    	
    	this.addAll(cards);
    	
    	shuffle();

        //for (Card c:cards) {
        //	System.out.println( c );
        //}
       	
       	//System.out.println(((JSONObject) cards.get(0)).get("cost"));
       	
	}
	
	public void shuffle() {
		Collections.shuffle(this);
	}
	
	public Card draw() {
		
		int firstCard = size() - 1;
		
		if (firstCard < 0) {
			throw new IllegalStateException("Have run out of cards");
		}
		
		Card card = this.get(firstCard);
		
		this.remove(firstCard);
		
		return card;
	}
	
//	public List<Card> drawN(int numberOfCards){
//		
//		List<Card> returnedCards = new ArrayList<Card>();
//		
//		if (this.cards.size() < numberOfCards) {
//			throw new IllegalStateException("Will run out of cards in deck");
//		}
//		
//		for (int i=0; i<numberOfCards; ++i) {
//			
//				returnedCards.add(draw());
//		}
//		
//		return returnedCards;
//	}
//	
//	
}
