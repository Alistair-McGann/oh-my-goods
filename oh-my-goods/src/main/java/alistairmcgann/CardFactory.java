package alistairmcgann;

import java.util.Random;

public class CardFactory {
	
	public Card createRandom() {
		return new Card(new Random().nextInt());
	}
	
	
}
