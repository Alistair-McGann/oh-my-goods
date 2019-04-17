package alistairmcgann;

import java.util.ArrayList;
import java.util.List;


public class Game {
	private final Table table;
	private final List<Player> players;
	
	public List<Worker> workers;
	
	public Game() {
		
		table = new Table();
		
		Player player1 = new Player();
		Player player2 = new Player();
		
		players = new ArrayList<Player>();
		
		players.add(player1);
		players.add(player2);
		
	}	
	
}
