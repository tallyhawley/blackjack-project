package blackjack;

import java.util.Random;

public class Dealer extends AbstractPlayer {
	
		//instance variable - Deck 
		Deck deck;


		//constructors
		public Dealer() {
			super();
			deck = new Deck();
		}

		//method to shuffle
		public void shuffle() {
			deck.shuffle();
		}

		//method to deal a card
		public Card deal() {
			return deck.nextCard();
		}

		//hit method goes here
		public boolean hit() {
			if(this.getHandValue() < 17) {
				System.out.println("dealer hit!");
				return true;
			}
			return false;
		}
}
