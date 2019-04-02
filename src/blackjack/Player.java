package blackjack;

import static java.lang.System.*;
import java.util.Scanner;



//define Player class here 
public class Player extends AbstractPlayer{

	public Player() {
		super();
	}
	
	public boolean hit() {
		Scanner scan = new Scanner(System.in);
		System.out.print("do you want to hit? [y/n] -- ");
		String ans = scan.nextLine();
		if(ans.equalsIgnoreCase("y")) return true;
		else return false;
	}
	
		
	


}

