package week1;

public class UsingBuiltInFunctions {
   public static void main(String[] args) {
    //exampleOne();
    //exampleTwo();
    displayRandomNumber(6,12);
   }

   private static void displayRandomNumber(int lower, int upper) {
       
       for(int i = 0; i< 100; i++){
        int randomNumber = (int)(Math.random()*(upper-lower + 1)) + lower; 
           System.out.println(randomNumber);
       }
       
   }

   private static void exampleOne() {
       double x = 2.0;

       double y = Math.sqrt(x);
       System.out.println(y);

       double z  = Math.pow(x,2);
       System.out.println(z);
   }

   private static void exampleTwo() {
       double randomNumber = Math.random();
       //System.out.println(randomNumber);

       for(int i = 0; i< 100; i++){
           randomNumber = Math.random()*10;
           //System.out.println(randomNumber);
       }

       for(int i = 0; i< 100; i++){
        randomNumber = (int)(Math.random()*10) + 1;
        System.out.println(randomNumber);
    }
   }
}
