package games;

import java.util.ArrayList;
import java.util.Random;

public class Shuffle {
	int total_attempts = 0;
	int favourable_attempts = 0;

	public void shuffle_cards(ArrayList<Card> cards, ArrayList<Player> players, int num) {
		Random rand = new Random();
		for (int i = 0; i < cards.size(); i++) // shuffling cards
		{
			int r = i + rand.nextInt(cards.size() - i); // getting value of r in the range from 0 to cards.size()-i

			// swapping the elements
			Card temp = cards.get(r);
			cards.set(r, cards.get(i));
			cards.set(i, temp);
		}

		if (num > 0) { // initially players don't have cards so no need to run this for loop initially
			for (int i = 0; i < players.size(); i++) { // clearing all cards contained by each player so that we can
														// assign them cards again
				players.get(i).c.clear();
			}
		}

		int k = 0;
		for (int i = 0; i < 13; i++) { // assign the shuffled cards to each player
			for (int j = 0; j < players.size(); j++) {
				players.get(j).addCard(cards.get(k));
				k++;
			}
		}

	}

	public void check(ArrayList<Player> players) { // Check if each player has one spade and one face-card

		int player_found = 0;
		for (int i = 0; i < players.size(); i++) {
			boolean spade_found = false, face_found = false;
			int n = players.get(i).c.size();
			for (int j = 0; j < n; j++) {
				face_found = face_found || players.get(i).c.get(j).is_face;
				spade_found = spade_found || players.get(i).c.get(j).is_spade;
			}
			if (spade_found && face_found) {
				player_found += 1;
			}
		}

		if (player_found == 4) {
			favourable_attempts += 1;
		}
	}

	public float check_X_times(int times, ArrayList<Card> cards, ArrayList<Player> players) {
		int num = 0;
		while (times > 0) { // run this loop 100000 times
			shuffle_cards(cards, players, num);
			check(players);
			total_attempts += 1;
			times--;
			num++;
		}
		System.out.println("FAVOURABLE : " + favourable_attempts);
		System.out.println("TOTAL : " + total_attempts);
		return (1.0f * favourable_attempts) / total_attempts;
	}

}
