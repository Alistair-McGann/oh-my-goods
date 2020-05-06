package alistairmcgann;

import java.util.ArrayList;
import java.util.List;


public class Table {

	private Deck deck;
	private DiscardPile discardpile;
	private CardCollection communalCards;
	
	public List<Worker> workers;
	
	public Table() {
		
		this(new Deck(new CardCollection()), new DiscardPile(), new ArrayList<Worker>());
		
	}
	
	public Table(Deck deck, DiscardPile discardPile, ArrayList<Worker> workers) {
		this.deck = deck;
		this.discardpile = discardPile;
		this.workers = workers;
		
		this.communalCards = new CardCollection();
		
		for (int i=0; i<10; ++i) {
			workers.add(new Worker());
		}
	}
	
	public Card draw() {
		
		try {
			return deck.draw();
		} catch (IllegalStateException e) {
			System.out.println("No more cards left!");
			
			// Shuffle in the discard pile
			shuffleInDiscardPile();
			
			return deck.draw();
		}
	}
	
	public CardCollection drawN(int numberOfCards){
		
		CardCollection returnedCards = new CardCollection();
		
		if (deck.size() + discardpile.size() < numberOfCards) {
			throw new IllegalStateException("Have run out of cards");
		}
		
		for (int i=0; i<numberOfCards; ++i) {
			
				returnedCards.add(draw());
		}
		
		return returnedCards;
	}
	
	private void shuffleInDiscardPile() {
		deck.addAll(discardpile);
		discardpile.clear();
		deck.shuffle();
		
	}
	
	public void discardCard(Card card) {
		this.discardpile.add(card);
	}
	
	public void discardCards(CardCollection cards) {
		this.discardpile.addAll(cards);
	}

	public void drawDayPhase() {
		int sunnyCards = 0 ;
		while (sunnyCards < 2) {
			Card card = deck.draw();
			if (card.hasSun()) {
				sunnyCards++;
			}
			
			communalCards.add(card);
			
		}
	}
	
}
