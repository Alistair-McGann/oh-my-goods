package alistairmcgann;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TableTest extends TestCase {

	public void test_GIVEN_no_cards_in_deck_WHEN_card_drawn_THEN_discard_pile_shuffled_in() {
		
		DiscardPile discardPile = new DiscardPile();
		Deck deck = new Deck(CardCollection::new);
		Card testCard = new Card(2);
		
		discardPile.add(testCard);
		
		Table table = new Table(deck, discardPile, new ArrayList<Worker>());
		
		assertEquals(testCard, table.draw());
		// Try adding a shuffle method (dependency injection) to the discard pile to stop random test errors
	}
	
}
