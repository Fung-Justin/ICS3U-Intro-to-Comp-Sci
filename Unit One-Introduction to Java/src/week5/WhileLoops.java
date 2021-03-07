package week5;
import java.util.Scanner;

public class WhileLoops {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

        System.out.println(exampleOne(1,10));
       

       
        loopExampleTwo(in);
     
        System.out.println("please enter a sentence. ");
        String sentence = in.nextLine();
        int numVowels = countVowels2(sentence);
        System.out.println("there are " + numVowels + ".");
        
    }
   
    
    private static int countVowels2(String text) {
        int numVowels = 0;
        int index = 0;
        while (index <= text.length()){
            String letter = text.substring(index,index + 1);
            if("AEIOUaeiou".indexOf(letter) >=0){
                numVowels++;
            }
            
            index++;
        }
        return numVowels;
    }
    

    private static int countVowels(String text) {
        int numVowels = 0;
        int index = 0;
        while (index <= text.length()){
            String letter = text.substring(index,index + 1);
            if(letter.equalsIgnoreCase("a")|| letter.equalsIgnoreCase("e")||letter.equalsIgnoreCase("i") || letter.equalsIgnoreCase("o")
            || letter.equalsIgnoreCase("u") )
            numVowels++;
            index++;
        }
        return numVowels;
    }

    private static void loopExampleTwo(Scanner in) {
        String mysteryColour = "red";
        String colour = null;
        System.out.print("What is the mystery colour?");

        while(colour == null || !mysteryColour.equalsIgnoreCase(colour) ){
            System.out.print("what is the mystery colour? ");
            colour = in.nextLine();
        }

    }

    /**
     * @param start
     * @param end
     * @return
     * 
     * 
     */ 

    private static int exampleOne(int start, int end) {

    int result = 0;
    int i = start;

    while(i<end){
        result += i;
        
     i++;
    }
    return result; 
       
    }
}
 