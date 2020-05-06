package alistairmcgann;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import alistairmcgann.decisions.ArtificialDecisionEngine;
import alistairmcgann.decisions.PromptDecisionEngine;


public class Game {
	private final Table table;
	private final List<Player> players;
	
	public List<Worker> workers;
	
	public Game() {
		
		table = new Table();
		
		Player player1 = new Player(this, new PromptDecisionEngine());
		Player player2 = new Player(this, new ArtificialDecisionEngine());
		
		players = Arrays.asList(player1, player2);
		
	}	
	
	public Table getTable() {
		return this.table;
	}
	
	public List<Player> getPlayers() {
		return Collections.unmodifiableList(players);
	}
	
	public void dealCards() {
		for (Player player: players) {
			player.drawN(2);
		}
	}
	
	private void orderOfPlay() {
		players.forEach(Player::drawAtStartOfGame);

		while (endOfGameNotTriggered()) {
			// Describes each round
			players.forEach(Player::drawAtStartOfRound);
			players.forEach(player->player.drawN(2));
			// Draw morning
			table.drawDayPhase();
			players.forEach(Player::queryBuildBuilding);
		}
	}
	
	
	private boolean endOfGameNotTriggered() {
		
	//	players.stream().map(Player::getBuildings).map(Collection::size).anyMatch(6::)
		for (Player player: players) {
			if (player.getBuildings().size() > 6) {
				return true;
			}
		}
		return false;
	}
	
}
