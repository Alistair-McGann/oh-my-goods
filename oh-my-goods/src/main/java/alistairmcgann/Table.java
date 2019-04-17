package alistairmcgann;

import java.util.ArrayList;
import java.util.List;


public class Table {

	private Deck deck;
	private DiscardPile discardpile;
	
	public List<Worker> workers;
	
	public Table() {
		
		deck = new Deck();
		
		for (int i=0; i<2; ++i) {
			System.out.println(deck.draw());
		}
		
		discardpile = new DiscardPile();

		workers = new ArrayList<Worker>();
		
		for (int i=0; i<10; ++i) {
			workers.add(new Worker());
		}
		
	}
	
}
