package alistairmcgann;

import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

public class DeckTest extends TestCase {

	public void test_GIVEN_empty_deck_WHEN_draw_THEN_error() {
		List<Card> cards = Collections.emptyList();
		Deck deck = new Deck(cards);
		
		try {
			deck.draw();
			fail();
		} catch ( IllegalStateException e) {
			// Expected
		}
	}
	
}
