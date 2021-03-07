package week5;

import java.util.Scanner;

public class hangman {

    private static int BADGUESSES = 7; 

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sentence = "baseball is the best sport out there";
        String usedLetters = "";
        
        int incorrectguess = 0;

        while(incorrectguess < BADGUESSES){
            String guess = getLetter(usedLetters, in);
           
        usedLetters += guess;
        hiddenmessage(sentence, usedLetters);
        if(sentence.indexOf(guess) < 0){
            incorrectguess++; 
            System.out.println();
            System.out.println(" wrong guess, you have guessed " + incorrectguess + " wrong");

        }
    
        } 
        
    }

    private static String getLetter(String usedLetters, Scanner in) {
        
        String validinput= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String letter = " ";
        boolean isValid = false; 

        while(!isValid){
            System.out.println("Please enter a letter" + displayUsedletters(usedLetters));
            System.out.println();
            
            letter = in.nextLine();
            if(letter.length() ==1 && validinput.indexOf(letter)>= 0 && usedLetters.indexOf(letter)< 0){
                
                return letter; 
                
                
            }else{
                System.out.println("invalid guess, only letters are allowed and you cannot enter a letter you have already input");
            }


        }
        return null;
    }

    private static String displayUsedletters(String usedLetters) {
        String letters = "";

        for(int i = 0; i< usedLetters.length(); i++){
        String temp = usedLetters.substring(i, i+1);
        usedLetters = temp + ", ";
        }
        return usedLetters;
    }

    private static void hiddenmessage(String sentence, String usedLetters) {
        for(int i= 0; i<sentence.length();  i++){
            String temp = sentence.substring(i,i+1);
            if(temp.equals(" ")){
                System.out.print("/ ");
            }else if (usedLetters.indexOf(temp) < 0){
                System.out.print("__ ");

            }else{
                System.out.print(temp +" ");
            }


        }
    }
    
    
	
}
