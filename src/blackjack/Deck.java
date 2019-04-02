package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;

	public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	private int topCardIndex;
	private ArrayList<Card> stackOfCards;

	public Deck ()
	{
		//initialize data - stackOfCards - topCardIndex
		stackOfCards = new ArrayList<Card>();
		
		//loop through suits
			//loop through faces
				//add in a new card
		for(String s : SUITS) {
			for(int i = 1; i <= NUMFACES; i++) {
				Card c = new BlackJackCard(i,s);
				stackOfCards.add(c);
			}
		}
		
		topCardIndex = stackOfCards.size()-1;
		
	}

	//modifiers
   public void shuffle ()
	{
		//shuffle the deck
		//reset variables as needed
	   Collections.shuffle(stackOfCards);
	   topCardIndex = 51;
	}

   //accessors
   
	public int  size ()
	{
		return stackOfCards.size();
	}

	public int numCardsLeft()
	{
		return topCardIndex + 1;
	}

	public Card nextCard()
	{
		return stackOfCards.get(topCardIndex--);
	}

	public String toString()
	{
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	} 
}
