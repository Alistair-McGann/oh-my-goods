package alistairmcgann;

import java.util.Set;


/**
 * 
 * @author alistair-mcgann
 * A class representing a card
 *
 */

public class Card {
	public int cost;
	private int points;
	private Resource resource;
	private Set<Resource> inputResources;
	private Resource derivedResource;
	private Set<Resource> productionChain;
	
	public Card(int cost) {
		this.cost = cost;
	}
	
	public String toString() {
		return String.format("I am a card with cost %d", this.cost);
	}

}
