package alistairmcgann;

import java.util.Collections;
import java.util.function.Supplier;
/**
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
*/
public class Deck extends CardCollection {

   	
   	public Deck(CardCollection inputCards) {
   		this.addAll(inputCards);// = inputCards;
   		//System.arraycopy(inputCards, 0, this.cards, 0, inputCards.size());
   	}
   	
	public Deck(Supplier<CardCollection> supplier) {
		

    	this.addAll(supplier.get());
    	
    	shuffle();

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
	
}
