package week1;

public class StringContatonation{
    public static void main(String[] args) {
        //exampleOne();
        //exampleTwo();
        //exampleThree();
        exampleFour();
    }
    // remainder using the modulus operator
    private static void exampleFour() {
        int x = 11; 
        int y = x % 2;

        System.out.println(y);  
        
        boolean isEven = (x % 2) == 0;

        System.out.println(isEven);
    }  

    private static void exampleThree() {
        int x =4, y=3;
        
        System.out.println(x + y);
        System.out.println(x + "+" + y +"=" + (x+y));

    }

    private static void exampleTwo() {
        int x = 4; 
        int y =3; 
        int sum = x + y;
        

        System.out.println(x + "+" + y +"=" + sum);

    }
    

    private static void exampleOne() {
        int markOne = 90;
        int markTwo = 94;
        int markThree = 88;
        
        final int numtests = 3; // final means that the value of the variable does not change  and is not a double because there is no decimal tests

        double average = (markOne + markTwo + markThree) /(double)numtests; //expected it to be 90.666667

        // int/int = int (truncated)   int/double = double

        System.out.println(average);
    }
    
}