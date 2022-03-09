package games;

public class Card {
	String name;
	int number;
	boolean is_face, is_spade;

	public Card(String name, int number) { // Constructor
		this.name = name;
		this.number = number;
		this.is_face = false;

		if (number == 1 || number >= 11) { // Ace and Face Cards //consider an ace card as face card
			this.is_face = true;
		}

		this.is_spade = false;
		if (name == "SPADE") {
			this.is_spade = true;
		}
	}

}
