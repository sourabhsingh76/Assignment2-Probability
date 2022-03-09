package games;

import java.util.ArrayList;

public class CardsGame { // to calculate the probability

	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>(); // declaring an ArrayList of type Player
		players.add(new Player("player1"));
		players.add(new Player("player2"));
		players.add(new Player("player3"));
		players.add(new Player("player4"));

		ArrayList<Card> cards = new ArrayList<Card>(); // declaring an ArrayList of type Card

		String[] name = { "SPADE", "HEART", "DIAMOND", "CLUB" };
		for (String n : name) { // adding 52 playing cards in the ArrayList of cards
			for (int card_number = 1; card_number <= 13; card_number++) {
				cards.add(new Card(n, card_number));
			}
		}

		Shuffle shuffle = new Shuffle(); // declaring an instance of Shuffle class
		int times = 100000;
		float prob = shuffle.check_X_times(times, cards, players);
		System.out.println("PROBABILITY : " + prob);

	}

}
