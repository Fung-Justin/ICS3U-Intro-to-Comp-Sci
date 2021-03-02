package week6;



public class ThreeCardPoker {
    private static final int DIAMOND = 1;
    private static final int HEARTS = 2;
    private static final int CLUBS = 3;
    private static final int SPADES  = 4;
    private static final int ACE = 14;
    private static final int JACK = 11;
    private static final int QUEEN = 12;
    private static final int KING = 13;
    public static void main(String[] args) {

        String playerHand = dealCards();
        String dealerHand = dealCards();
    
        System.out.println("Player: " + playerHand);
        System.out.println("Dealer: " + dealerHand);

        
    }
    public static boolean isUnique(String playerHand, String card) {
        return playerHand.indexOf(card) == -1;
      }


    private static String dealCards() {
        String cards = "";
    
        for (int i = 0; i < 3; i++) {
          Boolean hasCard = false;
          while (!hasCard) {
            String card = getCard();
            if (isUnique(cards, card)) {
              cards += card + " ";
              hasCard = true;
            }
          }
        }
        return cards;
      }


      private static boolean isStraightFlush(String hand){
          if(isFlush(hand) && isStraight(hand)){
              return true;
          }

          return false; 
      }
    private static boolean isFlush(String hand) {
        int space = hand.indexOf(" ");
        int space2 = hand.indexOf(" ", space+1);
        String card1 = hand.substring(0,space);
        String card2 = hand.substring(space+1,space2);
        String card3 = hand.substring(space2+1,hand.length());

        if(card1.substring(card1.length()-1).equals(card2.substring(card2.length()-1)) 
        && card2.substring(card2.length()-1).equals(card3.substring(card3.length()-1))) {
            return true;
        }
        

        return false;
        

    }
    
    private static boolean isPair(String hand){
        int space = hand.indexOf(" ");
        int space2 = hand.indexOf(" ", space+1);
        String card1n = hand.substring(0,space-1);
        String card2n = hand.substring(space+1,space2-1);
        String card3n = hand.substring(space2+1,hand.length()-1);

        if(card1n.equals(card2n)|| card2n.equals(card3n)|| card3n.equals(card1n)){
            return true; 
        }
        return false; 
    }

    private static boolean isStraight(String hand) {
        int space = hand.indexOf(" ");
        int space2 = hand.indexOf(" ", space + 1);
        String face1 = hand.substring(0,space - 1);
        String face2 = hand.substring(space+1,space2 - 1);
        String face3 = hand.substring(space2+1,hand.length() - 1);
        String order = "2345678910JQKA";
  
        int getMax = Math.max(order.indexOf(face1), Math.max(order.indexOf(face2), order.indexOf(face3)));
        int getMin = Math.min(order.indexOf(face1), Math.min(order.indexOf(face2), order.indexOf(face3)));
        int getMiddle = (order.indexOf(face1)  + order.indexOf(face2) + order.indexOf(face3)) - (getMax + getMin);
  
        if(getMax - 1 == getMiddle && getMiddle - 1 == getMin)
          return true;
  
      return false;
    }

    private static boolean IsThreeOfKind(String hand) {
        int space = hand.indexOf(" ");
        int space2 = hand.indexOf(" ", space + 1);
        String card1n = hand.substring(0, space - 1);
        String card2n = hand.substring(space + 1, space2 - 1);
        String card3n = hand.substring(space2 + 1, hand.length() - 1);
    
        if(card1n.equals(card2n) && card2n.equals(card3n))
            return true;
    
          return false;
      }


    
    private static String getFace() {
        int face = (int) ((Math.random()*(14 -2)) +2);

        if( face <= 10){
            return face + "";
        }else if (face == 11){
            return "J";
        }else if (face ==12){
            return "Q";
        }else if (face ==13){
            return "K";
        }else if (face ==14){
            return "A";
        }
        return null;
    }

    private static String getSuit() {
        int random = (int)(Math.random()*4)+1;
        if(random == DIAMOND)
        return "D";
        else if (random ==HEARTS)
        return "H";
        else if (random == CLUBS)
        return "C";
        else if (random == SPADES)
        return "S";
        return null;

    }

    private static String getCard() {
        return  getFace() + getSuit() ;
    }

    

}
