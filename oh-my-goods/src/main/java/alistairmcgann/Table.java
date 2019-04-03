package alistairmcgann;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;


public class Table {

	private Deck deck;
	private DiscardPile discardpile;
	
	public List<Worker> workers;
	
	public Table() {
		
		deck = new Deck();
		
		discardpile = new DiscardPile();

		workers = new ArrayList<Worker>();
		
		for (int i=0; i<10; ++i) {
			workers.add(new Worker());
		}
		
	}
	
}
