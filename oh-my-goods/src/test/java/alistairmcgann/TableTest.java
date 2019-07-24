package alistairmcgann;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

public class TableTest extends TestCase {

	
	public void test_GIVEN_no_cards_in_deck_WHEN_card_drawn_THEN_discard_pile_shuffled_in() {
		
		DiscardPile discardPile = new DiscardPile();
		Deck deck = new Deck(CardCollection::new, Collections::shuffle);
		Card testCard = new Card(2);
		
		discardPile.add(testCard);
		
		Table table = new Table(deck, discardPile, new ArrayList<Worker>());
		
		assertEquals(testCard, table.draw());
		// Try adding a shuffle method (dependency injection) to the discard pile to stop random test errors
	}
	
	public void test_GIVEN_two_cards_in_deck_WHEN_card_drawn_THEN_first_card_returned_first() {
		
		DiscardPile discardPile = new DiscardPile();
		
		// Deck(empty card collection, no-op lambda shuffle function)
		Deck deck = new Deck(CardCollection::new, i -> {});
		
		for (int i=1; i<30; i++) {
			discardPile.add(new Card(i));
		}
		
		// Otherwise the discard pile is backwards
		Collections.reverse(discardPile);
		
		Table table = new Table(deck, discardPile, new ArrayList<Worker>());
		
		for (int i=1; i<30; i++) {
			assertEquals(i, table.draw().cost);
		}
		
	}
	
	
	public void test_GIVEN_deck_with_N_cards_WHEN_N_cards_drawn_THEN_all_cards_are_returned() {
		int numberOfCards = 10;
		
		// Deck(empty card collection, no-op lambda shuffle function)
		Deck deck = new Deck(CardCollection::new, i -> {});
		CardCollection testCards = new CardCollection();
		
		for (int i=0; i<numberOfCards; i++) {
			testCards.add(new Card(i));
		}

		deck.addAll(testCards);
		
		Table table = new Table(deck, new DiscardPile(), new ArrayList<Worker>());
		
		List<Card> returnedCards = table.drawN(numberOfCards);
				
		for (int i=0; i<numberOfCards; ++i) {
			assertTrue(returnedCards.contains(testCards.get(i)));
		}
		
		assertTrue(returnedCards.size() == numberOfCards);
	}
	
}
