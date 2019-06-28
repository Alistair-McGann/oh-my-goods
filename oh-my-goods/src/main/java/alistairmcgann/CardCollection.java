package alistairmcgann;

import java.util.ArrayList;
import java.util.Collection;

public class CardCollection extends ArrayList<Card>{
	
	public CardCollection() {}
	
	public CardCollection(Collection<Card> collection) {
		super(collection);
	}
	
	public Card pop() {
		// Assumes removing the top card
		int index = size() - 1;
		Card returnedCard = this.get(index);
		this.remove(index);
		return returnedCard;
	}
}
