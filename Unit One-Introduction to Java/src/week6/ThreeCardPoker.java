package week6;

import java.util.Scanner;

public class ThreeCardPoker {
    private static final int DIAMOND = 1;
    private static final int HEARTS = 2;
    private static final int CLUBS = 3;
    private static final int SPADES = 4;
    private static final int ACE = 14;
    private static final int JACK = 11;
    private static final int QUEEN = 12;
    private static final int KING = 13;
    private static final int STRAIGHTF = 40;
    private static final int THREEKIND = 30;
    private static final int STRAIGHT = 6;
    private static final int FLUSH = 3;
    private static final int PAIR = 1;
    private static final int HIGHCARD = 0;
    private static final String order = "2345678910JQKA";
    private static int BAL;
    private static int ANTE;
    private static int PAIRP;
    private static int PLAY;
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        getBal(in);
        /*

        while ( BAL > 0) {
            
            

            getAnte(in);
         getPlusP(in);
            System.out.println("Your Balance: " + BAL);
            
              String playerHand = dealCards(); String dealerHand = dealCards();
              System.out.println();
              
              System.out.println("Player: " + playerHand); 
              getPlay(in);
              System.out.println("Dealer: " +dealerHand);
              
              System.out.println();
              
              System.out.println(winner(playerHand, dealerHand));
              BAL = 0;
        } 
        */
      System.out.println(winner("2H 2S QH ","3H 3S 2C " ));
    }

    public static boolean isUnique(String playerHand, String card) {
        return playerHand.indexOf(card) == -1;
    }

    private static void getAnte(Scanner in) {
        
        // ANTE WAGER
        System.out.println("Please enter your ante wager ($50-$100)");
        String ante = in.nextLine();

        boolean validante = false;
        while (!validante) {

            try {
                int number = Integer.parseInt(ante);
                if (number > 100 || number < 50) {
                    Integer.parseInt("o");
                }
                validante = true;
            }

            catch (NumberFormatException ex) {
                System.out.println("Please enter a wager between $50-$100");
                ante = in.nextLine();
            }

        }
        
            BAL -= Integer.parseInt(ante);

            ANTE = Integer.parseInt(ante);
    }

        private static int getPlusP(Scanner in){

        // PAIR PLUS WAGER
        System.out.println("Do you want to enter a pair plus wager? Y/N");
        String res = in.nextLine();

        if (res.substring(0, 1).equalsIgnoreCase("Y")) {
            System.out.println("Please enter how much you want to bet");
             String pairP = in.nextLine();

            boolean validpair = false;
            while (!validpair) {

                try {
                    int num = Integer.parseInt(pairP);
                    if (num > (0.9 * BAL)) {
                        Integer.parseInt("o");
                    }
                    validpair = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Please enter a number or a wager that is less than 90% of your balance");
                    pairP = in.nextLine();
                }                

            }
            
            BAL -=Integer.parseInt(pairP);
            return Integer.parseInt(pairP);
        }

        return 0;
    }

    private static void getBal(Scanner in) {
        System.out.println("Hello, Please enter your balance, remeber that you need to pay this back!");
        String balance = in.nextLine();
        boolean validInput = false;
        while (!validInput) {
            try {
                int number = Integer.parseInt(balance);
                validInput = true;
            } catch (NumberFormatException ex) {
                System.out.print("Please enter a number: ");
                balance = in.nextLine();
            }
        }
        BAL = Integer.parseInt(balance);
    }

    private static int getPlay(Scanner in){
        System.out.println("Do you want to enter a play wager? Y/N");
        String res = in.nextLine();

        if (res.substring(0, 1).equalsIgnoreCase("Y")) {
            System.out.println("Please enter how much you want to bet");
             String play = in.nextLine();

            boolean validplay = false;
            while (!validplay) {

                try {
                    int num = Integer.parseInt(play);
                    if (num > BAL) {
                        Integer.parseInt("o");
                    }
                    validplay = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Please enter a valid wager");
                    play = in.nextLine();
                }                

            }
            
            BAL -= Integer.parseInt(play);
            return Integer.parseInt(play);
        }

        return 0;
    }

    

    // COMPARING PAIRS = HIGHCARD
    private static int compareHand(String phand, String dhand) { // 1 == player wins, 2 == dealer wins, 0 == push
        if (checkHand(phand) == checkHand(dhand) && highCard(phand) == highCard(dhand)) {

            return 0;
        } else if (checkHand(phand) == checkHand(dhand) && highCard(phand) > highCard(dhand)) {

            return 1;

        } else if (checkHand(phand) == checkHand(dhand) && highCard(phand) < highCard(dhand)) {

            return 2;
        } else if (checkHand(phand) > checkHand(dhand))
            return 1;
        else
            return 2;

    }

    private static String winner(String playerHand, String dealerHand) {
        if (compareHand(playerHand, dealerHand) == 1) {
            System.out.println();
            return "Player Wins";
        } else if (compareHand(playerHand, dealerHand) == 2) {
            System.out.println();
            return "Dealer Wins";
        }
        System.out.println();
        return "Push, no winners";

    }

    private static int checkHand(String hand) {

        if (isStraightFlush(hand))
            return STRAIGHTF;
        //
        else if (IsThreeOfKind(hand))
            return THREEKIND;
        else if (isFlush(hand))
            return FLUSH;
        else if (isStraight(hand))
            return STRAIGHT;
        else if (isPair(hand))
            return PAIR;
        else
            return HIGHCARD;
    }

    private static int highCard(String hand) {
        int space = hand.indexOf(" ");
        int space2 = hand.indexOf(" ", space + 1);
        String card1 = hand.substring(0, space - 1);
        String card2 = hand.substring(space + 1, space2 - 1);
        String card3 = hand.substring(space2 + 1, hand.length() - 2);

        int hCard = Math.max(order.indexOf(card1), Math.max(order.indexOf(card2), order.indexOf(card3)));

        if (order.indexOf(card1) == hCard) {

            return order.indexOf(card1);

        } else if (order.indexOf(card2) == hCard) {

            return order.indexOf(card1);

        }

        return order.indexOf(card3);

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

    private static boolean isStraightFlush(String hand) {
        if (isFlush(hand) && isStraight(hand)) {
            return true;
        }

        return false;
    }

    private static boolean isFlush(String hand) {
        int space = hand.indexOf(" ");
        int space2 = hand.indexOf(" ", space + 1);
        String card1 = hand.substring(0, space - 1);
        String card2 = hand.substring(space + 1, space2 - 1);
        String card3 = hand.substring(space2 + 1, hand.length() - 2);

        if (card1.substring(card1.length() - 1).equals(card2.substring(card2.length() - 1))
                && card2.substring(card2.length() - 1).equals(card3.substring(card3.length() - 1))) {
            return true;
        }

        return false;

    }

    private static boolean isPair(String hand) {
        int space = hand.indexOf(" ");
        int space2 = hand.indexOf(" ", space + 1);
        String card1n = hand.substring(0, space - 1);
        String card2n = hand.substring(space + 1, space2 - 1);
        String card3n = hand.substring(space2 + 1, hand.length() - 2);

        if (card1n.equals(card2n) || card2n.equals(card3n) || card3n.equals(card1n)) {
            return true;
        }
        return false;
    }

    // ACE + 2 + 3 EXCEPTION
    private static boolean isStraight(String hand) {
        int space = hand.indexOf(" ");
        int space2 = hand.indexOf(" ", space + 1);
        String card1 = hand.substring(0, space - 1);
        String card2 = hand.substring(space + 1, space2 - 1);
        String card3 = hand.substring(space2 + 1, hand.length() - 2);
        String order = "2345678910JQKA";

        int getMax = Math.max(order.indexOf(card1), Math.max(order.indexOf(card2), order.indexOf(card3)));
        int getMin = Math.min(order.indexOf(card1), Math.min(order.indexOf(card2), order.indexOf(card3)));
        int getMiddle = (order.indexOf(card1) + order.indexOf(card2) + order.indexOf(card3)) - (getMax + getMin);

        if (getMax - 1 == getMiddle && getMiddle - 1 == getMin)
            return true;

        return false;
    }

    private static boolean IsThreeOfKind(String hand) {
        int space = hand.indexOf(" ");
        int space2 = hand.indexOf(" ", space + 1);
        String card1n = hand.substring(0, space - 1);
        String card2n = hand.substring(space + 1, space2 - 1);
        String card3n = hand.substring(space2 + 1, hand.length() - 2);

        if (card1n.equals(card2n) && card2n.equals(card3n))
            return true;

        return false;
    }

    private static String getFace() {
        int face = (int) ((Math.random() * (14 - 2)) + 2);

        if (face <= 10) {
            return face + "";
        } else if (face == JACK) {
            return "J";
        } else if (face == QUEEN) {
            return "Q";
        } else if (face == KING) {
            return "K";
        } else if (face == ACE) {
            return "A";
        }
        return null;
    }

    private static String getSuit() {
        int random = (int) (Math.random() * 4) + 1;
        if (random == DIAMOND)
            return "D";
        else if (random == HEARTS)
            return "H";
        else if (random == CLUBS)
            return "C";
        else if (random == SPADES)
            return "S";
        return null;

    }

    private static String getCard() {
        return getFace() + getSuit();
    }

}
