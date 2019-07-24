package alistairmcgann;

import java.util.List;

public class Player {
	
	private CardCollection hand;
	private final Table table;
	
	public Player(Table table) {
		this.table = table;
		
	}
	
	public void drawN(int numberOfCards) {
		hand.addAll(table.drawN(numberOfCards));
	}
	

}
