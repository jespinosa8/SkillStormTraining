package Java.Day1.Collections;

import Java.Day1.FourPillars.*;

public class ArrayPractice {
  public static void main(String[] args) {  

    /*
     * Arrays
     *  - stores data in contiguous memory locations
     *  - access through each address using indexes. Indexes start at 0
     * 
     *  - use square brackets to access specific index 
     */

    int[] numbers1 = {1,2,3};      // creates an array with 3 filled memory locations
    int[] numbers2 = new int[3];   // array with 3 spots taken but no real values 

    System.out.println(numbers1);
    System.out.println(numbers2);

    int num = numbers1[2];
    System.out.println(num);    // prints the value at index location 2

    Vehicle[] vehicles = new Vehicle[2];
    vehicles[0] = new Car();
    vehicles[1] = new Segway();


    /*
     *  LOOP
     *    while
     *    do-while
     *    for
     *    for-each (advanced for loops)
     * 
     *    interators (not really a loop - more on these later) 
     */

     /*
      * FOR LOOPS
      *    declare 3 things: iteration variable, condition, and the step
      */

    System.out.println("FOR LOOP");
    for(int i = 0; i < 3; i++) {
      numbers2[i] = numbers1[i];

      System.out.println("\t" + numbers2[i]);
    }

    /*
     *  FOR EACH 
     *    similar to for loops
     *      don't have access to index, just loops through data structure 
     */

    System.out.println("FOR EACH");
    for(int x : numbers1) {
      System.out.println(x);
    }

    /*
     * WHILE LOOPS
     *  loop until some condition is false 
     */

    System.out.println("WHILE LOOP");
    int i = 2;
    while(i >= 0) {
      System.out.println("\t" + numbers2[i]);

      i--;
    }


    /*
     * DO-WHILE
     *  will always run at least once
     *  they check the condition at the end
     *  
     */

    System.out.println("DO WHILE");
    int j = 2;
    do {
            System.out.println("\t" + numbers2[j]);

            j--;

    } while(j >= 0);
    
  }

}
