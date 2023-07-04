package Java.Day2.FileIO;

import java.io.PrintWriter;
import java.util.Scanner;

public class CmdLineIO {
  
  public static void main(String[] args) {
    
    // default is the command line
    System.out.println("Hello World!");


    /*
     * SCANNER 
     */
    
    /*
     * all data has to be stored into a variable
         primitive type or a String ONLY 
     */

     Scanner scanIn = new Scanner(System.in);   // tells the scanner to use the default system input


      // use .nextLine() to read in Strings
      System.out.print("Enter a string: ");   // print doesn't append a newline to the end of your text
      String textInput = scanIn.nextLine();
      System.out.println("You entered: " + textInput);

      // use .next<primitive data type>() to read in data of that type
      System.out.println("Enter a number: ");
      double numInput = scanIn.nextDouble();
      System.out.println("You entered: " + numInput);

      // must close your scanners! otherwise memory leaks
      scanIn.close();



      /*
       * PRINT WRITER
       *    allows for better formatting of print statements
       *    also allows you to queue up several prints and flush them out at once 
       */

      String name = "Brendan";
      int age = 22;
      double height = 173.5;

      // normal method without print writer
      System.out.println(name + " is " + age + " years old and is " + height + " cm tall!");

      // the same as above can be done with PrintWriter using printf
      PrintWriter consoleOut = new PrintWriter(System.out);
      consoleOut.printf("%s is %d years old and is %.2f cm tall!\n", name, age, height);   // wildcards must match data type of variables
      consoleOut.print("Prints a normal string!");
      consoleOut.append(" This string will be added to the end of the previous one!");

      // need to call flush to clear your print writer queue
      consoleOut.flush();

      // must close your writers! otherwise memory leaks
      consoleOut.close();
  }
}
