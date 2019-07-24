package alistairmcgann;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Game {
	private final Table table;
	private final List<Player> players;
	
	public List<Worker> workers;
	
	public Game() {
		
		table = new Table();
		
		Player player1 = new Player(table);
		Player player2 = new Player(table);
		
		players = Arrays.asList(player1, player2);
		
	}	
	
	public void dealCards() {
		for (Player player: players) {
			player.drawN(2);
		}
	}
	
}
