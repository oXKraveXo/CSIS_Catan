package catan;

import java.util.Arrays;

public class Deck {
Cards [] cards = new Cards[25];

public Deck () {
	for (int i = 0; i<cards.length; i++) {
		if (i <= 13)
			cards[i] = new Cards("Knights/SoliderCards", 0);
		if (i >= 14)
			cards[i] = new Cards("Progress Cards", 1);
		if (i >= 20 && i < 25)
			cards[i] = new Cards("Victory Point Cards", 2);
	}
}

@Override
public String toString() {
	String temp = "";
	for(int i = 0; i<cards.length; i++)
		temp = temp+ "\n" + "    " + cards[i];
	return temp; 
	
	//return "Deck [cards=" + Arrays.toString(cards) + "]";
}

}
