package Cards;

import java.util.*;

public class Card {
   private String face;
   private int rank;
   private Suit suit;
@Override
public String toString() {
	int idx = face.equals("10")?2:1;
	String faceStr = face.substring(0,idx);
	 
	return "%s%c(%d)".formatted(faceStr,suit.getImage(),rank);
}
   
public static Card getNumericCard(Suit suit,int cardno) {
	if(cardno >1 && cardno<11) {
		return new Card(String.valueOf(cardno),cardno-2,suit);
	}
	System.out.println("Invalid numveric number!!");
	return null;
}

public static Card getFaceCard(Suit suit,char abbrev) {
	int idx = "JKQA".indexOf(Character.toUpperCase(abbrev));
	
	if(idx>-1) {
		return new Card(""+abbrev,idx+9,suit);
	}
	System.out.println("Invalid card was passed");
	return null;
}

public Card(String face, int rank, Suit suit) {
	this.face = face;
	this.rank = rank;
	this.suit = suit;
}

public static List<Card> getDeck(){
	
	List<Card> deck = new ArrayList<>(52);
	for(Suit suit : Suit.values()) {
		
		for(int i=2;i<=10;i++) {
			deck.add(getNumericCard(suit,i));
		}
		
		
		char[] faces = {'J','K','Q','A'};
	      for (char c:faces) {
	    	  deck.add(getFaceCard(suit,c));
	      }
	}
	return deck;
	
}

public static void printDeck(List<Card> deck,String description,int rows) {
	System.out.println("-----------------------------------------------------------------------------------");
	if(description!=null) {
		System.out.println(description);
	}
	
	int cardsinRow = deck.size()/rows;
	
	for(int i=0;i<rows;i++) {
		int sIdx = i*cardsinRow;
		int eIdx = sIdx + cardsinRow;
		deck.subList(sIdx, eIdx).forEach(c -> System.out.print(c + " "));
		System.out.println();
	}
}


public static void printDeck(List<Card> deck) {
	printDeck(deck,"",4);
}



}
