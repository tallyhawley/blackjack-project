package blackjack;

public abstract class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;

  	//constructors
	
	public Card() {
		this.suit = "";
		this.face = 0;
	}
	
	public Card(int face, String suit) {
		this.suit = suit;
		this.face = face;
	}


	// modifiers

	public void setSuit(String s) {
		this.suit = s;
	}
	
	public void setFace(int f) {
		this.face = f;
	}
 

  	//accessors

	public String getSuit() {
		return suit;
	}
	
	public int getFace() {
		return face;
	}

  	public abstract int getValue();

	public boolean equals(Object obj)
	{
		if(obj == this) return true;
		
		if(obj == null) return false;
		
		if(getClass() != obj.getClass()) return false;
		
		Card c = (Card) obj;
		
		return c.getSuit().equals(suit) && c.getFace() == face;
	}

  	//toString
	public String toString() {
		return FACES[face] + " of " + getSuit() + " | value = " + getValue();
	}
  	
 }