package alistairmcgann.decisions;

import java.util.List;

import alistairmcgann.CardCollection;
import alistairmcgann.Player;

public class ArtificialDecisionEngine implements IDecisionEngine{

	@Override
	public boolean discardHand(Player self, List<Player> players, CardCollection hand) {
		int numberOfCardsInHand = hand.size(); 
		
		// Dumb AI - always discard
		System.out.println(String.format("Beep boop, I am discarding %d cards", numberOfCardsInHand));
		return true;
	}
	
}

