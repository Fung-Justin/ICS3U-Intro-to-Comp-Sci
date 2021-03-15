package week8;
/**
 * Rhw FameCubve will model a simple Die that could be usec for a board game, a dice game or any game that 
 * equires a random number
 * 
 * the class will contain:
 * State:  The current state of this gaemcube
 * Behaviour: the things that we can do with the gamecube
 */
public class GameCube {
   private int topSide; // attributes for a dice
   private int numSides;// instance variables 
    
   /**
    * Method to create a game cube - create a constructor
    The purpose of the constructor is to create an isntance of the calse
    The constructor is a method with the same name as the class
    */
    public GameCube(int numberOfSides){
        numSides = numberOfSides;
        roll();
    }
    /**
     * OverLoaded the constructor
     */
    public GameCube(){
       numSides = 6;
        roll();
    }
    /**
     * rolling is equivilant of resetting the top side
     */

    public void roll(){
        topSide = (int)(Math.random()* numSides + 1);
    }

    public int getTopSide(){
        return topSide; 
    }
}
