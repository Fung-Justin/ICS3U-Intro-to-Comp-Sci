package week5;
import java.util.Scanner;;

public class ForLoops {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

      drawRectangle(4,6,"8");
      ecoo2010(4,3,1,2);
        
    }

    private static void ecoo2010(int m, int n, int p, int q) {
        //top padding
        for(int i = 0; i <(n+2*p+2*q); i++){
            System.out.print("#");
        }
        System.out.println();


        for(int k = 0; k < p; k++){

            for (int j = 0; j < q; j++){
                System.out.print("#");
            }

            for(int k = 0; k < p)
        }
    }

    private static void drawRectangle(int width, int height, String symbol) {

        for (int row = 0; row < height; row++){
        for(int i = 0; i<= width; i++){
            System.out.print(symbol);
        }
        System.out.println();
    }

    
    }

    
}
