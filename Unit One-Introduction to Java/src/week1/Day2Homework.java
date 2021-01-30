package week1;

public class Day2Homework {
    public static void main(String[] args) {
        questionOne(10);
        questionTwo(15.0);
        questionThree(15,9,8,4);
        questionFour(15,16,12,23); 
        questionFive(46,50,50,50,45,50);
        questionSix(1,-8,5);
        
    }

   

   


    private static void questionOne(double radius) {

        double area = (Math.PI* Math.pow(radius,2)); 

        System.out.println(area + " cm^2");
    }
    

    private static void questionTwo(double radius ){
        double volume = (4.0/3.0)*Math.PI*Math.pow(radius, 3);

        System.out.println(volume + " cm^3");

    }
    private static void questionThree( double a, double b, double c, double x) {
        double y = (a*Math.pow(x, 2)) + (b*x) + c; 

        System.out.println(y);

    }
    private static void questionFour(int x1, int y1, int x2, int y2) {
        int deltaX = x2-x1;
        int deltaY = y2-y1;

        

        System.out.println(deltaX +","+ deltaY);



    }
    private static void questionFive(int numP, int numN, int numD, int numQ, int numL, int numT) {
        double total = (numP * 0.01) + (numN * 0.05) + (numD*0.10) + (numQ * 0.25) + (numL) + (numT * 2);


        System.out.println("$" + total);
    }
    

    private static void questionSix( double a, double b, double c) {
        double x1 = ((b*-1) + (Math.sqrt(Math.pow(b, 2) - (4*a*c))))/ (2*a);
        double x2 = ((b*-1) + (Math.sqrt(Math.pow(b, 2) - (4*a*c)))*-1)/ (2*a);
        
    

        System.out.println( x1 + ", " + x2);

    }
}
