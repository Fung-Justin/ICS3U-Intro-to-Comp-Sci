package week2;

public class StringExamples {
  public static void main(String[] args) {
      //exampleOne();
     // exampleTwo();
      exampleThree();
  }

  private static void exampleThree() {
    String s1 = new String("Steve"); // Must use the string.equals() method in order to compare 2 strings like s2 and s1
    String s2 = new String("Steve"); // comparing strings that are declared like s1 and s2 will return FALSE
    String s3 = "Steve"; // comparing strings that are declared like s3 and s4 WILL return as true
    String s4 = "Steve";

    System.out.println(s1.equals(s2));

  }
/*
  private static void exampleTwo() {
      String coursecode = "ICS3U AP";
    
      int x = coursecode.length();

      String sub = coursecode.substring(2,5); // "SCU" starts at index 2 and dends at index 4 
      System.out.println("the length of \"" + coursecode + "\" is:" + x);
  }

  private static void exampleOne() {
      String simpletext = "this is a string.";

      System.out.println(simpletext);
  }
  */
}
