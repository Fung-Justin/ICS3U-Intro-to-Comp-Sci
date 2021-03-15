package week8;

public class DiceGame {
    public static void main(String[] args) {
        GameCube playerOne = new GameCube(); 
        GameCube playerTwo = new GameCube();



        int numRolls = 10;
        int score1 = 0;
        int score2 = 0;

        for(int i = 0; i < numRolls; i++){
            playerOne.roll();
            playerTwo.roll();
            if(playerOne.getTopSide() > playerTwo.getTopSide())
                score1++;
            else if(playerTwo.getTopSide() > playerOne.getTopSide())
                score2++;
                else{
                    System.out.println("DRAW");
                }
        }
        System.out.println("-----------FINAL Score----------");
        System.out.println("Player 1: " + score1);
        System.out.println("Player 2: " + score2);
    }
}
