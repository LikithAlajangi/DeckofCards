package Cards;

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
   
public Card getNumericCard(Suit suit,int cardno) {
	if(cardno >1 && cardno<11) {
		return new Card(String.valueOf(cardno),cardno-2,suit);
	}
	System.out.println("Invalid numveric number!!");
	return null;
}

public Card getFaceCard(Suit suit,char abbrev) {
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

}
