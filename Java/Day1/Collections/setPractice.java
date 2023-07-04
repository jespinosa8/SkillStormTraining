package Java.Day1.Collections;

import java.util.HashSet;
import java.util.Iterator;

public class setPractice {
  public static void main(String[] args) {
    /*
     * SETS
     *    unordered
     *    only unique values - no duplicates
     * 
     *    no indexes - use interators to loop through them
     * 
     */

     HashSet<String> names = new HashSet<>();
     names.add("Austin");
     names.add("Caroline");
     names.add("Jordan");

     System.out.println(names);


     /*
      * ITERATORS
            allows you to move through a collection, without a loop

            so you can move through a collection at your own pace
      */
      System.out.println("ITERATOR");
      Iterator<String> nameItr = names.iterator();

      String name1 = nameItr.next();
      System.out.println(name1);

      System.out.println(nameItr.next());

      Iterator<String> nameItr2 = names.iterator();
      while(nameItr2.hasNext()) {
        System.out.println(nameItr2.next());
      }
  }
}
