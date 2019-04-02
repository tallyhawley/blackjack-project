package blackjack;

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack{
	//add in Player instance variable
	Player player;
	//add in Dealer instance variable
	Dealer dealer;

	public BlackJack()
	{
		player = new Player();
		dealer = new Dealer();
	}

	public void playGame()
	{
		Scanner scan = new Scanner(System.in);
		char choice = 0;
		boolean play = true;
		
		do {
			player.resetHand();
			dealer.resetHand();
			dealer.shuffle();
			
			player.addCardToHand(dealer.deal());
			player.addCardToHand(dealer.deal());
			
			dealer.addCardToHand(dealer.deal());
			dealer.addCardToHand(dealer.deal());
			
			System.out.println("PLAYER");
			print(player);
			while(player.getHandValue() < 21 && player.hit()) {
				player.addCardToHand(dealer.deal());
				print(player);
				
			}
			System.out.println("DEALER");
			print(dealer);
			while(dealer.hit()) {
				dealer.addCardToHand(dealer.deal());
				print(dealer);
			}
			
			
			if(dealer.getHandValue() > 21) {
				System.out.println("player wins - dealer busted!");
				player.setWinCount(player.getWinCount()+1);
			}else if(player.getHandValue() > 21) {
				System.out.println("dealer wins - player busted!");
				dealer.setWinCount(dealer.getWinCount()+1);
			}else if(player.getHandValue() > dealer.getHandValue()) {
				System.out.println("player has bigger hand value!");
				player.setWinCount(player.getWinCount()+1);
			}else if(player.getHandValue() < dealer.getHandValue()) {
				System.out.println("dealer has bigger hand value!");
				dealer.setWinCount(dealer.getWinCount()+1);
			}else if(player.getHandValue() == dealer.getHandValue()) {
				System.out.println("hand values are equal! it's a tie!");
			}
			
			System.out.println("dealer has won " + dealer.getWinCount() + " times.");
			System.out.println("player has won " + player.getWinCount() + " times.");
			
			System.out.print("would you like to play again? [y/n] -- ");
			String ans = scan.nextLine();
			if(!ans.equalsIgnoreCase("y")) {
				play = false;
			}
			
		}while(play);

	}
	
	public void print(AbstractPlayer player) {
		System.out.println("hand value: " + player.getHandValue());
		System.out.println("hand size: " + player.getHandSize());
		System.out.println("cards in hand: " + player);
	}
	
	public static void main(String[] args)
	{
		BlackJack game = new BlackJack();
		game.playGame();
	}
}
