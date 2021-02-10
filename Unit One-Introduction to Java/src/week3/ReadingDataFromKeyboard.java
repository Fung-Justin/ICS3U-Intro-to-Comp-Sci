package week3;

import java.util.Scanner;

public class ReadingDataFromKeyboard {
    public static void main(String[] args){
        exampleOne();
        exampleTwo();
    }

    private static void exampleTwo() {
        Scanner in = new Scanner(System.in);
        System.out.println(" please enter a 5 digit integer:");
        int number = Integer.parseInt(in.nextLine());
        int sum = MoreFunctions.getSum(number);
        System.out.println(sum); 

    }

    private static void exampleOne() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your favourite colour:");
        String favouriteColour = in.nextLine();
        System.out.println(favouriteColour); 


    
    }
 
}


