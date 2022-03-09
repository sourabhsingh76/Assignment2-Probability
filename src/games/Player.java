package games;

import java.util.ArrayList;

public class Player {
	String name;
	ArrayList<Card> c = new ArrayList<Card>(); // declaring an ArrayList of type Card

	public Player(String name) { // constructor
		super();
		this.name = name;
	}

	public void addCard(Card card) {
		c.add(card);
	}

}
