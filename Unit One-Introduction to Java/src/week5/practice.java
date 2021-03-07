package week5;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class practice {
    
    public static void main(String[] args) {
        readFromFile();
        getInput();
    }

    private static void getInput() {
        
    }

    private static void readFromFile() {
        try{
        Scanner in = new Scanner( new File ("src\\week5\\clues.dat"));
        while(in.hasNextLine()){
            String text = in.nextLine();
            System.out.println(text);
            in.close();
        }
        } catch (FileNotFoundException e) {
            System.out.println("could not locate the file");
            System.exit(0);
        }
    }
}
