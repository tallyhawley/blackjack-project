package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack{
	
	private ArrayList<Playerable> players;

	public BlackJack()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("enter the number of players: ");
		int amt = scan.nextInt();
		players = new ArrayList<Playerable>();
		players.add(new Dealer());
		for(int i = 0; i < amt; i++) {
			players.add(new Player());
		}
	}

	public void playGame()
	{
		Scanner scan = new Scanner(System.in);
		boolean play = true;
		
		Dealer dealer = (Dealer) players.get(0);
		
		do {
			// shuffle deck & reset hands
			dealer.shuffle();
			for(Playerable p : players) {
				p.resetHand();
			}
			
			// deal 2 cards
			for(int i = players.size()-1; i >= 0; i--) {
				players.get(i).addCardToHand(dealer.deal());
				players.get(i).addCardToHand(dealer.deal());
			}
			
			// player's turns
			for(int i = 1; i < players.size(); i++) {
				Player player = (Player) players.get(i);
				System.out.println("PLAYER " + i);
				print(player);
				while(player.getHandValue() < 21 && player.hit()) {
					player.addCardToHand(dealer.deal());
					print(player);
				}
				System.out.println();
			}
			
			// dealer's turn
			System.out.println("DEALER");
			print(players.get(0));
			while(players.get(0).hit()) {
				players.get(0).addCardToHand(dealer.deal());
				print(players.get(0));
			}
			
			System.out.println();
			
			// check who won & update win total
			ArrayList<Integer> possibleWinners = new ArrayList<Integer>();
			for(Playerable p : players) {
				if(p.getHandValue() <= 21) {
					possibleWinners.add(players.indexOf(p));
				}
			}
			// if all busted except one
			if(possibleWinners.size() == 1) {
				if(possibleWinners.get(0) == 0) {
					System.out.println("dealer won! all other players busted.");
					players.get(0).setWinCount(players.get(0).getWinCount() + 1);
				}
				else {
					System.out.println("player " + possibleWinners.get(0) + " won! all other players busted.");
					players.get(possibleWinners.get(0)).setWinCount(players.get(possibleWinners.get(0)).getWinCount() + 1);
				}
			}
			// if all busted
			else if(possibleWinners.size() == 0) {
				System.out.println("tie - all players busted!");
			}
			// else
			else if(possibleWinners.size() > 1) {
				int maxInd = 0;
				int maxHand = players.get(0).getHandValue();
				boolean allEqual = allEqual(possibleWinners, players);
				for(int i : possibleWinners) {
					if(players.get(i).getHandValue() > maxHand) {
						maxHand = players.get(i).getHandValue();
						maxInd = i;
					}
				}
				if(allEqual) {
					System.out.println("tie - all non-busted players have the same hand value!");
				}
				else if(maxInd == 0) {
					System.out.println("dealer won! (largest hand value)");
					players.get(0).setWinCount(players.get(0).getWinCount() + 1);
				}else {
					System.out.println("player " + maxInd + " won! (largest hand value)");
					players.get(maxInd).setWinCount(players.get(maxInd).getWinCount() + 1);
				}
			}
			
			// print win statement
			System.out.println("dealer has won " + players.get(0).getWinCount() + " times.");
			for(int i = 1; i < players.size(); i++) {
				System.out.println("player " + i + " has won " + players.get(i).getWinCount() + " times.");
			}
			
			System.out.println();
			
			System.out.print("would you like to play again? [y/n] -- ");
			String ans = scan.nextLine();
			if(!ans.equalsIgnoreCase("y")) {
				play = false;
			}
			System.out.println();
			
		}while(play);

	}
	
	private void print(Playerable player) {
		System.out.println("hand value: " + player.getHandValue());
		System.out.println("hand size: " + player.getHandSize());
		System.out.println("cards in hand: " + player);
	}
	
	private boolean allEqual(ArrayList<Integer> pw, ArrayList<Playerable> players) {
		int hand = players.get(0).getHandValue();
		for(int i : pw) {
			if(players.get(i).getHandValue() != hand) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		BlackJack game = new BlackJack();
		game.playGame();
	}
}
