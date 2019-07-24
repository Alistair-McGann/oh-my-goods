package alistairmcgann;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

public class DeckTest extends TestCase {

	public void test_GIVEN_empty_deck_WHEN_draw_THEN_error() {
		CardCollection cards = new CardCollection();
		Deck deck = new Deck(cards);
		
		try {
			deck.draw();
			fail();
		} catch ( IllegalStateException e) {
			// Expected
		}
	}
	
	public void test_GIVEN_deck_with_single_card_WHEN_card_drawn_THEN_card_returned_and_deck_is_empty() {
		Card testCard = new Card(1);
		
		CardCollection cards = new CardCollection(Arrays.asList(testCard));
		
		Card returnedCard;
		
		Deck deck = new Deck(cards);

		returnedCard = deck.draw();
			
		assertEquals(testCard, returnedCard);
		assertEquals(deck.size(), 0);
	}
	
	public void test_GIVEN_deck_with_one_card_WHEN_two_cards_drawn_THEN_error() {
		Card testCard = new Card(1);
		
		CardCollection cards = new CardCollection(Arrays.asList(testCard));
		
		Deck deck = new Deck(cards);
		
		// Draw card out of deck
		deck.draw();
		
		try {
			deck.draw();
			fail();
		} catch ( IllegalStateException e ) {
			// Expected
		}
	}
	

}
