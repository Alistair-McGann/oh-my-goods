package alistairmcgann.decisions;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import alistairmcgann.Card;
import alistairmcgann.CardCollection;
import alistairmcgann.Player;

public class PromptDecisionEngine implements IDecisionEngine{
	
	@Override
	public boolean discardHand(Player self, List<Player> players, CardCollection hand) {
		
		Optional<Boolean> discardHand = Optional.empty();

		try( Scanner input = new Scanner(System.in)) {
				
			while(!discardHand.isPresent()) {
			
				System.out.println("Discard hand? [Y/N]");
			
				String userInput = input.next().toLowerCase();
		
				switch(userInput) {
					case ("yes"):
					case ("y"): {
						discardHand = Optional.of(true);
						break;
					}

					case ("no"):
					case ("n"): {
						discardHand = Optional.of(false);
						break;
					}
				
					default:
						System.out.println("Invalid input, try again");
				}
			
			}
				
		}
		
		// This must be set after the while loop by the user
		return discardHand.get();
	}
	
	private boolean getYesNo() {
		Optional<Boolean> answer = Optional.empty();
		
		try( Scanner input = new Scanner(System.in)) {

		
			String userInput = input.next().toLowerCase();

		
			switch(userInput) {
			case ("yes"):
			case ("y"): {
				// This returns the first card in the hand for simplicity
				answer = Optional.of(true);
				break;
			}

			case ("no"):
			case ("n"): {
				answer = Optional.of(false);
				break;
			}
	
			default:
				System.out.println("Invalid input, try again");
			}
		}
	}
	
	public Optional<Card> buildBuilding(Player self, CardCollection hand){
		
		Optional<Card> buildingToBuild = Optional.empty();
		
		System.out.println("Your hand:");
		for (Card card: hand) {
			System.out.println(card);
		}
		
		try( Scanner input = new Scanner(System.in)) {
			
				
				
				
			for (Card card: hand) {
				
				System.out.println(card);
				
				System.out.println("Do you want to build this building? [Y/N]");
			
				Boolean buildCard = getYesNo();
				
				if (buildCard && !buildingToBuild.isPresent()) {
					buildingToBuild = Optional.of(card);
					//break;
				}
			
			}
			
			hand.stream().filter(this::wantsToBuildThis).findFirst();

	}
	}
			
	private boolean wantsToBuildThis(Card c) {
		System.out.println(c);
		
		System.out.println("Do you want to build this building? [Y/N]");
	
		return getYesNo();
	}
	}
	
}
