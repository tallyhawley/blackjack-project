package blackjack;

public class BlackJackCard extends Card
{
  	//constructors
	
	public BlackJackCard() {
		super();
	}
	
	public BlackJackCard(int face, String suit) {
		super(face,suit);
	}



  	public int getValue()
  	{
  		//enables you to build the value for the game into the card
  		//this makes writing the whole program a little easier
  		if(2 <= getFace() && getFace() <= 10) {
  			return getFace();
  		}
  		else if(getFace() <= 13 && getFace() > 10) {
  			return 10;
  		}
  		else if(getFace() == 1) return 11;
  		return 0;
  	}
  	
 }