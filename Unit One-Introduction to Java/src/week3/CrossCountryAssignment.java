package week3;

import java.util.Scanner;

public class CrossCountryAssignment {
    static String mile3;
     static String mile2;
     static String mile1; 
     static String fName;
     static String lName; 
     
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        runnerData(in);
        //runnerTime(mile1, mile2, mile3);
        
        //runnerData(in);
        //runnerTime(mile1,mile2,mile3);
       
    }

    
    

    public static String getSplit( double m1){
     String split = (m1/60) + "";
     int decimal = split.indexOf(".");
     int minutes = Integer.parseInt(split.substring(0,decimal));
     double seconds = Double.parseDouble(split.substring(decimal))*60;
        String fsplit = String.format("%d:%06.3f", minutes, seconds); 
        
        
        
        return fsplit; 
    }

    public static double getSec(String m){
        int colon = m.indexOf(":");
        int minutes = Integer.parseInt(m.substring(0,colon)) *60;
     double seconds = Double.parseDouble(m.substring(colon+1));

        double s = minutes + seconds; 

     return s;


    }

    private static void runnerTime( String m1, String m2, String m3 ) {


     
     double split1 = getSec(m1);
         
     double split2 = getSec(m2) + split1;
    
     double split3 = getSec(m3) - split2;

     System.out.println("Name of runner:" + fName +" " + lName);

    System.out.println("Split one: " + getSplit(split1) + " min");
    System.out.println("Split two: " + getSplit(split2) + " min" );
    System.out.println("Split three: " + getSplit(split3) + " min");
    System.out.println ("Total Time: " + getSplit(split3 + split2) + " min");

     



    

    }

    public static void runnerData(Scanner in) {
      
        
        System.out.println("Please enter your first name:");
     fName = in.nextLine(); 

        System.out.print("Please enter your last name: \r\n" );
     lName = in.nextLine();

    System.out.print( "Welcome " + fName + " " + lName + " please enter your first mile time in the format (Minute:Seconds.Milliseconds) \r\n" );
        mile1 = in.nextLine();

   System.out.println("Next, enter your time for your second mile time: \r\n");
         mile2 = in.nextLine();

   System.out.println("Finally, please enter the total time of the run\r\n");
        mile3 = in.nextLine();
        
    }
    

    
}
