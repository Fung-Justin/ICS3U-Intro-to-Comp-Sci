package week3;

public class FunctionsandScanner {
public static void main (String[] aStrings){
/*int number = 53273;

int sum = getSumVersion2(number);

//int sum = getSum(number);
System.out.println(sum);

*/

String y = "Baseball";

System.out.println(y.substring(11,18));



}

private static int getSumVersion2(int number) {
    String numString = " " + number; 

   int  digOne = Integer.parseInt(numString.substring(0,1));
    return digOne;
}

public static int getSum(int number) {
    int digit1 = number/10000;
    int digit2 = number / 1000 % 10;
    int digit3 = number/ 100 % 10;
    int digit4 = number /10 % 10;
    int digit5 = number %10;

    return digit1 + digit2 + digit3 + digit4 + digit5; 

    
}
    
}    

