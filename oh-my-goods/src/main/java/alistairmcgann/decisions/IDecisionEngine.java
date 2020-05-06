package alistairmcgann.decisions;

import java.util.List;
import java.util.Optional;

import alistairmcgann.Card;
import alistairmcgann.CardCollection;
import alistairmcgann.Player;

// This is a 'strategy pattern'
public interface IDecisionEngine {

	// List<Player> players so we can get all buildings which have been built
	public boolean discardHand(Player self, List<Player> players, CardCollection hand);
	
	public Optional<Card> buildBuilding(Player self, CardCollection hand);
}
