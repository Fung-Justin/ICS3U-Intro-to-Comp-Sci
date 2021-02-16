package week3;

public class FunctionsHomework {
    public static void main(String[] args) {
        //questionOne( 935.0, 5.5);
        //questionTwo(23.36,4.5);
        //questionThree();
        //questionFour();
        //questionFive(110,44);
        //questionSix(10,12);
        double temp = 98;
        questionSeven(temp);
        question8();
        
        
    }

    private static void question8() {
        
    }

    private static void questionSeven(double f) {
       double C = (f-32)*(5.0/9.0);
       double temp = Math.round(C);
        C = temp; 
        System.out.println( f + " Farenheit is equal to " + C + "celcius" );
    }

    private static void questionSix(int mass, int speed) {

        double momentum = mass*speed;

        System.out.print("The momentum of this object was " + momentum + "m/s");

    }

    private static void questionFour() {
        double lightMin =  (3 *Math.pow(10,8)) * 60;

        double lightYear = lightMin*525600; 

        System.out.println("In a year, light would travel " + lightYear + " meters");

    }

    private static void questionFive(int W, int L) {
        int gameTotal = W + L;
        double winRate = (double) W /gameTotal;
        System.out.println(winRate);
        
        double Rrate = (double) Math.round(winRate*1000);
         Rrate =  Rrate/1000;

         System.out.println("The 1927 New York Yankees win rate was: " + Rrate + "%" );

        
    }

    public static void questionThree() {
        int minDay = 60*24;
        
        int minTotal = minDay*365;

        

        System.out.println("There are a total of " + minTotal + " minutes in a calendar year");
        

    }

    private static void questionTwo(double length, double width) {
        double area = length*width;
        double perimeter =  (2*length) + (2*width);
        
        double rArea = Math.round(area*100);
        double rPerimeter = Math.round(perimeter*10); 
        rArea = rArea/10;
        rPerimeter= rPerimeter/10;

        System.out.println(rArea);
        System.out.println(rPerimeter);


    }

    private static void questionOne(double price, double tax) {
     double total = price + (price*tax); 

     System.out.println(total);
    }
}
