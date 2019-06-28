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
	
//	public void test_GIVEN_deck_with_N_cards_WHEN_N_cards_drawn_THEN_all_cards_are_returned() {
//		int numberOfCards = 10;
//		
//		List<Card> testCards = new ArrayList<Card>();
//		
//		for (int i=0; i<numberOfCards; ++i) {
//			testCards.add(new Card(i));
//		}
//		
//		Deck deck = new Deck(new ArrayList<Card>(testCards));
//		
//		List<Card> returnedCards = deck.drawN(numberOfCards);
//		
//		System.out.println(testCards);
//		
//		for (int i=0; i<numberOfCards; ++i) {
//			assertTrue(returnedCards.contains(testCards.get(i)));
//		}
//	}
}
