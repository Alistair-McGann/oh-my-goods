package alistairmcgann;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import alistairmcgann.decisions.IDecisionEngine;

public class Player {

	private final CardCollection hand;
	private final CardCollection buildings;
	private final Table table;
	private final IDecisionEngine decisionEngine;
	private final Game game;

	private Optional<Card> buildingToBuild;
	
	public Player(Game game, IDecisionEngine decisionEngine) {
		this.table = game.getTable();
		this.hand = new CardCollection();
		this.buildings = new CardCollection();
		this.decisionEngine = decisionEngine;
		this.game = game;
		
		this.buildingToBuild = Optional.empty();
	}

	public void drawN(int numberOfCards) {
		hand.addAll(table.drawN(numberOfCards));
	}

	public void drawAtStartOfGame() {
		drawN(5);
	}
	
	private void discardHand() {
		table.discardCards(hand);
		hand.clear();
	}
	
	public void drawAtStartOfRound() {
		int handSize = hand.size();
		
		if (queryDiscardHand()) {
			discardHand();
			drawN(handSize);
		}

	}
	
	public void buildBuilding() {		
		if (this.buildingToBuild.isPresent()) {
			throw new RuntimeException("Building to build cannot be left over from previous round");
		}
		
		this.buildingToBuild = queryBuildBuilding();
		
	}
	
	private boolean queryDiscardHand() {
		return decisionEngine.discardHand(this, game.getPlayers(), hand);
	}

	private Optional<Card> queryBuildBuilding() {
		return decisionEngine.buildBuilding(this, hand);
	}
	
	public List<Card> getBuildings(){
		return Collections.unmodifiableList(buildings);
	}

}
