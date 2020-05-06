package alistairmcgann;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.function.Supplier;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class CardReader implements Supplier<CardCollection>{

	private String filepath = new String();
	
	private static final Type CARD_TYPE = new TypeToken<CardCollection>(){}.getType();
	
   	Gson gson = new Gson();
   	
   	FileReader filereader;
   	JsonReader jsonreader;
	
	@Override
	public CardCollection get() {

      filepath = "C:\\Users\\mcga\\git\\oh-my-goods\\oh-my-goods\\src\\main\\java\\alistairmcgann\\cards.json";
		 
      try {
			filereader = new FileReader(filepath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

  	CardCollection cards = new Gson().fromJson(filereader, CARD_TYPE);
  	
  	// Hack to increase deck size
  	cards.addAll(cards);
  	cards.addAll(cards);
  	cards.addAll(cards);
  	cards.addAll(cards);
  	cards.addAll(cards);
  	cards.addAll(cards);
  	  	
  	
		
		// TODO Auto-generated method stub
		return cards;
	}
	
}
