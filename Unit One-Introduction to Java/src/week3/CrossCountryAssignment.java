package week3;

import java.util.Scanner;

public class CrossCountryAssignment {
    static int runNum = 0; //this variable keeps track of the number of the runners and will increase by 1 every time runnerData is called in the program

    
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        runnerData(in);
        runnerData(in);
        runnerData(in);
        
    }
 
    //converts the time which is in seconds(double), back into the normal time format, Min:sec.mili returns a String
    public static String getSplit( double m1){
        String split = (m1/60) + "";
        /**Divide the double by 60 to get the number of minutes, which will turn up to be a number with many decimals afterwards(eg. 5.32323412) */  
        // turn it into a string so that it will be easier to seperate the digits before and after the decimal so that the proper operations can be performed

        int decimal = split.indexOf(".");
        int minutes = Integer.parseInt(split.substring(0,decimal));
        // the number of minutes would be equal to the numbers from the beginning up until the decimal point in the string
        double seconds = Double.parseDouble(split.substring(decimal))*60;
        // the seconds would need to be calculated by taking all the numbers after the decimal, and multiplying it by 60 to find the seconds
        String fsplit = String.format("%d:%06.3f", minutes, seconds ); 
        // .format is needed to correctly format the string properly with the ":" in the right place 
        // it also prevents issues like 3:6.125123123 where a 0 needs to be added on the right of the "6" and the decimals need to be limited to 3 spots
        // %d:%06.3f - tells that the String will be formated so that the integer (d%) will be put first on the string, then followed by ":" 
        // it will then put a 0, then specifies that the string will be at lest 6 characters, and it can only have 3 characters after the decimal (".")
        
    return fsplit; 
    }

// gets the time which is in typical M:S.M form (string), and converts it into seconds. returns a double
    public static double getSec(String m){
        int colon = m.indexOf(":");
        //finding the index of the colon so that it can be used to seperate the string by minutes and seconds
        int minutes = Integer.parseInt(m.substring(0,colon)) *60;
        // takes all the characters between 0 and colon and multiplies it by 60 to convert minutes to seconds
        double seconds = Double.parseDouble(m.substring(colon+1));
        // takes all the numbers after the colon, no math needs to be done since the numbers are already seconds
        double s = minutes + seconds; 

     return s;


    }
    // calls other functions like getsec and getSplit and displays all the information to the runner
    private static void runnerTime( String m1, String m2, String m3, String fName, String lName ) {
        double split1 = getSec(m1);
         // uses method getSec to convert the string into seconds so that it can be added and subtracted to find the splits, 
        double split2 =  getSec(m2)- split1 ;
        // to find the time of the second split, the time that it took to complete the second mile needs to be subtracted by the first split 
        double split3 = getSec(m3) - (split2 + split1);
        // split three is calculated by taking the total time and subtracting all the other splits

        System.out.println("Summary of Runner "  + runNum + ": "+ fName +" " + lName);

        System.out.println("Split one: " + getSplit(split1) + " min"); // turns the splits in the form of a seconds (double), to the conventional way time is displayed(string) using getSplit
        System.out.println("Split two: " + getSplit(split2) + " min" );
        System.out.println("Split three: " + getSplit(split3) + " min");
        System.out.println ("Total Time: " + getSplit(split3 + split2 + split1) + " min\r\n");
        // prints back out a summary of the data
    

    }
    // gets all the information that is required by the runner to input, and uses scanners to assign the data inputed to variables
    public static void runnerData(Scanner in) {
        runNum++;
        // runNum is used here
        System.out.println("Runner #" + runNum +" please enter your first name:");
        String fName = in.nextLine(); 
        //scanner gets the keyboard inputs and stores them into the variables so that it can be passed onto the runnerTime method 
        System.out.print("Please enter your last name: \r\n" );
        String lName = in.nextLine();

        System.out.print( "Welcome " + fName + " " + lName + ", please enter the time when you completed the first mile in the format (Minute:Seconds.Milliseconds) " );
        String mile1 = in.nextLine();

        System.out.println("Next, enter the time when you completed the second mile ");
        String mile2 = in.nextLine();

        System.out.println("Finally, please enter the total time of the run");
        String mile3 = in.nextLine();

       runnerTime(mile1, mile2, mile3, fName, lName);
        
    }
    

    
}
