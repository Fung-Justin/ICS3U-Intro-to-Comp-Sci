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
    private static final String order = "02345678910JQKA";
    private static int BAL;
    private static int ANTE;
    private static int PAIRP;
    private static int PLAY;
    private static boolean playAgain = true;
    private static boolean validhand;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    
        getBal(in);

        while (BAL >= 0 && playAgain) {
            getAnte(in);
            getPlusP(in);

            System.out.println("\r\nYour Balance: $" + BAL);

            String playerHand = dealCards();
            String dealerHand = dealCards();
            System.out.println("\r\n Your Hand: " + playerHand);

            if (getPlay(in)) {
                System.out.println("\r\nDealer's Hand: " + dealerHand);

                if (checkHand(dealerHand) == HIGHCARD && highCard(dealerHand) <= JACK) {
                    System.out.println("\r\ndealer hand is worse than Jack-high, your play wager is returned");
                    validhand = false;
                    BAL -= ANTE;
                    BAL += PLAY;
                } else {
                    validhand = true;
                    System.out.println(winner(playerHand, dealerHand));
                }
            }
            payout(playerHand, dealerHand);
            if (BAL > 0)
                playA(in);
            else
                System.out.println("\r\nYou have run out of money, you owe $" + (BAL * -1));
        } 
    }

    public static boolean isUnique(String playerHand, String card) {
        return playerHand.indexOf(card) == -1;
    }
/**
 *  Method to prompt player if they want to play again
 * @param in Scanner to get response from player
 * 
 * 
 */
    private static void playA(Scanner in) {
        System.out.println("\r\nDo you want to play again? Y/N");
        String res = in.nextLine();

        if (res.substring(0, 1).equalsIgnoreCase("Y")) {
            playAgain = true;
        } else 
            playAgain = false;
        
    }

    /**
     * Method payout is used to payout the pair plus wager, ante wager, and play wager
     * Boolean validHand is used to determine if the dealers hand follows rule A, and if valid hand is false, then the player will not get the payout
     * of ante and play wager, and will only get payout for the pair plus wager
     * the method adds the payout directly to the global variable BAL
     * @param playerHand used with method checkHand to determined how large the pairplus wager payout is
     * @param dealerHand used to determine the winner of the round by using compareHand method
     */
    private static void payout(String playerHand, String dealerHand) {
        if (PAIRP >= 0) {
            if (checkHand(playerHand) >= PAIR) {

                BAL += PAIRP + (PAIRP * (checkHand(playerHand)));
                System.out.println("\r\nPair plus wager: + $" + (PAIRP + (PAIRP * (checkHand(playerHand)))));
                PAIRP = 0;
            } else {
                System.out.println("\r\nUnfortunately, you lost the pair plus wager");
            }
        }

        if (compareHand(playerHand, dealerHand) == 1 && validhand) {
            System.out.println("\r\nBalance: $" + BAL + " + $" + (2 * ANTE) + " + $" + (2 * PLAY));
            BAL += (2 * ANTE) + (2 * PLAY);
        } else if (compareHand(playerHand, dealerHand) == 0 && validhand) {
            BAL += ANTE + PLAY;
        } else {
            System.out.println("\r\nBalance: $" + BAL);
        }
    }
    /**
     * getAnte method is used to prompt the player for the ante wager
     * to enforce a wager between 50 and 100 dollars and to remain efficient, 
     * line 131 checks if the number is outside the range and forces a NumberFormatException
     * by parsing "o" so that the code used to check if a number or letter is inputted can also be used
     * to check for valid wagers. This strategy is used in other getWager methods
     * @param in
     */

    public static void getAnte(Scanner in) {
        // ANTE WAGER
        System.out.println("Please enter your ante wager ($50-$100)");
        String ante = in.nextLine();

        boolean validante = false;
        while (!validante) {

            try {
                int number = Integer.parseInt(ante);
                if (number > 100 || number < 50 || number > BAL) {
                    Integer.parseInt("o");
                }
                validante = true;
            }
            catch (NumberFormatException ex) {
                System.out.println("Please enter a wager between $50-$100");
                ante = in.nextLine();
            }

        }
        ANTE = Integer.parseInt(ante);
        BAL -= ANTE;
    }

    /**
     * PlusP is used for prompting user for pair plus wager
     * after the player is prompted for the option for a pair plus wager
     * the first character of the response is checked for a y, ignoring the case of the character
     * any other input is assumed as a no
     * @param in scanner is used to check for yes or no response, and the value of their wager
     */
    private static void getPlusP(Scanner in) {

        if (BAL >= 50) {
            System.out.println("Do you want to enter a pair plus wager? Y/N");
            String res = in.nextLine();

            if (res.substring(0, 1).equalsIgnoreCase("Y")) {
                System.out.println("Please enter a wager within $50 and $100");
                String pairP = in.nextLine();

                boolean validpair = false;
                while (!validpair) {
                    try {
                        int num = Integer.parseInt(pairP);
                        if (num > 100 || num < 50 || num > BAL) {
                            Integer.parseInt("o");
                        }
                        validpair = true;
                    } catch (NumberFormatException ex) {
                        System.out.println("Please enter a number, or enter a wager within the limits");
                        pairP = in.nextLine();
                    }
                }
                PAIRP = Integer.parseInt(pairP);
                BAL -= PAIRP;
            }
        }
    }
/**
 *  getBal assigns the value of the global variable BAL its value
 * and checks for valid input
 * @param in
 */
    private static void getBal(Scanner in) {
        System.out.println("Hello, Please enter your balance, remember that you need to pay this back!");
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
    /**
     * getPlay determines if the player wants to play with their hand or fold and assigns the value of PLAY
     * @param in like other methods it uses the scanner to check for y/n input from player
     * @return returns a true if player wants to play and false if they want to fold
     * the return of the method is used in the main while loop of the program to determine what happens
     * 
     */
    private static boolean getPlay(Scanner in) {
        System.out.println(
                "Do you want to enter a play wager equal to your ante wager or fold? Enter Y to play, enter N to fold");
        String res = in.nextLine();

        if (res.substring(0, 1).equalsIgnoreCase("Y")) {
            PLAY = ANTE;
            BAL -= ANTE;
            return true;
        }
        return false;
    }

    /**
     * pairValue that is used to determine the value of a pair 
     * in the event that both dealer and player have a pair, the value of the pair can be determined
     * @param hand takes the hand of either player of dealer to determine value
     * @return returns the pair value in the form of its index in the string ORDER 
     * ORDER is a string that has the order of the strengths of weakest to strongest, from 2 to ACE
     * 
     */

    private static int pairValue(String hand) {
        int space = hand.indexOf(" ");
        int space2 = hand.indexOf(" ", space + 1);
        String card1 = hand.substring(0, space - 1);
        String card2 = hand.substring(space + 1, space2 - 1);
        String card3 = hand.substring(space2 + 1, hand.length() - 2);

        if (order.indexOf(card1) == order.indexOf(card2))
            return order.indexOf(card1);

        return order.indexOf(card3);
    }

    // COMPARING PAIRS = HIGHCARD
    /**
     * The compareHand method is used for comparing dealer and player hands with each other using other methods
     * if both hands have the same value, eg. straight vs straight, the hand with the highest card is determined
     * in the special case where both hands have a pair, then the method pairValue is called to compare the strength of 
     * each hands pair
     * the method also checks if both hands are equal, which will result in a push
     * @param phand
     * @param dhand
     * @return returns and integer that indicates the winner,  1 == player wins, 2 == dealer wins, 0 == push
     */
    private static int compareHand(String phand, String dhand) { 
        if (checkHand(phand) == checkHand(dhand) && highCard(phand) == highCard(dhand))
            return 0;
        else if (checkHand(phand) == PAIR && checkHand(dhand) == PAIR && pairValue(phand) > pairValue(dhand))
            return 1;
        else if (checkHand(phand) == PAIR && checkHand(dhand) == PAIR && pairValue(phand) < pairValue(dhand))
            return 2;
        else if (checkHand(phand) == checkHand(dhand) && highCard(phand) > highCard(dhand))
            return 1;
        else if (checkHand(phand) > checkHand(dhand))
            return 1;
        else
            return 2;
    }

    // this method is just used for printing out the winning message depending on who is the winner
    private static String winner(String playerHand, String dealerHand) {
        if (compareHand(playerHand, dealerHand) == 1) {
            
            return "\r\nPlayer Wins";
        } else if (compareHand(playerHand, dealerHand) == 2) {
            return "\r\nDealer Wins";
        }
        return "\r\nPush, no winners";
    }
    /**
     * the checkHand method is used for both determining the payout of 
     * the pairplus wager and also used for comparing hands against each other
     * this is because hands that are stronger also have a higher payout, so the 
     * payout value can be used to compare the strength of a hand vs another, this is
     * used in the compareHand method
     * @param hand takes a hand and checks for special combinations using other methods
     * @return an integer that reflects the hands payout value
     */
    private static int checkHand(String hand) {

        if (isStraightFlush(hand)) {
            return STRAIGHTF;
        } else if (IsThreeOfKind(hand)) {
            return THREEKIND;
        } else if (isFlush(hand)) {
            return FLUSH;
        } else if (isStraight(hand)) {
            return STRAIGHT;
        } else if (isPair(hand)) {
            return PAIR;
        } else
            return HIGHCARD;
    }
    /**
     * highCard is used to determine the what is the highest value single card in a hand
     * to seperate the String hand, into 3 seperate cards, the method finds the index of 
     * spaces which seperate each card, the card are then assinged a string and the suit is taken away,
     * leaving only the first character. to find the high card, the string ORDER is used and Math.max
     * determines which card has the highest index, which is the highest value card
     * @param hand
     * @return the method then returns its index in the string Order
     */

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
            return order.indexOf(card2);
        }
        return order.indexOf(card3);
    }
     /**
      * dealCards deals 3 cards using a forloop using previous methods by calling getCard
      * the method also calls, isUnique to make sure a card is not repeated 
      * @return the hand of cards
      */
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
// checks for a straightflush by determining if both isFlush and isStraight is true
// returns a boolean
    private static boolean isStraightFlush(String hand) {
        if (isFlush(hand) && isStraight(hand)) {
            return true;
        }
        return false;
    }
    /**
     * checks for a flush by taking only the suit of each card 
     * checks for flush by checking if all the suits of card 1 2 and 3 are equal
     * @param hand
     * @return true or false boolean if it is a flush or not
     */
    private static boolean isFlush(String hand) {
        int space = hand.indexOf(" ");
        int space2 = hand.indexOf(" ", space + 1);
        String card1 = hand.substring(0, space);
        String card2 = hand.substring(space + 1, space2);
        String card3 = hand.substring(space2 + 1, hand.length() - 1);

        if (card1.substring(card1.length() - 1).equals(card2.substring(card2.length() - 1))
                && card2.substring(card2.length() - 1).equals(card3.substring(card3.length() - 1))) {
            return true;
        }
        return false;
    }
    /**
     * similar to highCard, isPair takes only the face of the card,
     * if 2 faces are equal, then it is a pair
     * @param hand
     * @return true or false boolean whether a hand is a pair or not
     */
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
/**
 * isStraight is used to determine if a hand has a straght
 * similar to other methods that check hands for combination, it seperates the cards into its own strings
 * using spaces. To check for a straight, the highest card, the lowest card and the middle card need to be determined
 * this is done using the getMax, getMin, and getMiddle methods which take the index of each card in the string ORDER
 * then, if the index of the max card -1 is equal to the middle card, and the index of middle card -1 is = to the smallest card
 * then it is a straight
 * A special case is ACE,2,3 and this straights needs to be specifically checked
 * @param hand
 * @return a boolean true or false 
 */
    // ACE + 2 + 3 EXCEPTION
    private static boolean isStraight(String hand) {
        int space = hand.indexOf(" ");
        int space2 = hand.indexOf(" ", space + 1);
        String card1 = hand.substring(0, space - 1);
        String card2 = hand.substring(space + 1, space2 - 1);
        String card3 = hand.substring(space2 + 1, hand.length() - 2);

        int getMax = Math.max(order.indexOf(card1), Math.max(order.indexOf(card2), order.indexOf(card3)));
        int getMin = Math.min(order.indexOf(card1), Math.min(order.indexOf(card2), order.indexOf(card3)));
        int getMiddle = (order.indexOf(card1) + order.indexOf(card2) + order.indexOf(card3)) - (getMax + getMin);
        if(getMax == order.indexOf("A") && getMin == order.indexOf("2") && getMiddle == order.indexOf("3"))
        return true;
       else if (getMax - 1 == getMiddle && getMiddle - 1 == getMin)
            return true;

        return false;
    }
    // method is similar to pair except it checks if all three cards are equal
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
    /**
     * finds a random number between 13 and 2
     * assigns every number above 10 with its respective face
     * @return
     */
    private static String getFace() {
        int face = (int) (Math.random() * 13 + 2);

        if (face <= 10 && face >=2) {
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
    // randomizes a number from 1 -4 and assigns the number its respective suit
    private static String getSuit() {
        int random = (int)(Math.random() * 4) +1;
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
    //creates a card using previous methods getsuit and getcard
    private static String getCard() {
        return getFace() + getSuit();
    }
}
