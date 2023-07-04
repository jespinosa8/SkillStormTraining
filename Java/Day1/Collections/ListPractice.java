package Java.Day1.Collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListPractice {
  /*
   * LISTS
   *    are indexed and ordered
   *    
   *    Collections API in Java - all lists will inherit from List class
   * 
   *    ONLY WORKS WITH OBJECTS
   *      Java gives you wrapper classes for primitive types
   *      int -> Integer
   *      double -> Double
   */

   public static void main(String[] args) {

    /*
     * ARRAY LISTS
     *    dynamic array
     *    unless you say otherwise, that starting capacity is 10
     *    once it is full, it grows by 50%
     *      1- -> 15 -> 23 etc
     * 
     *    lookup is O(1) with the index
     *    insertion is constant time at the end of array as well if there is no resizing
     *      if resizing then its O(n)
     *      if it's in the middle, it's O(n)
     */

    ArrayList<String> fruits = new ArrayList<>();

    fruits.add("mango");
    fruits.add("pineapple");
    fruits.add("dragonfruit");
    
    fruits.add(0, "banana");

    System.out.println(fruits);
    System.out.println(fruits.get(0));


    fruits.remove(0);
    System.out.println(fruits);

    // returns the index location of the first instance of the object
    fruits.indexOf("mango");


    /*
     * LINKED-LISTS
     *    non-consecutive memory locations 
     *    contain at least one pointer to the next node and your data at that node
     *    
     *    don't have indexes - lookup is O(n) 
     *    insertion at the front is O(1) 
     *      anywhere else is O(n) (marginally faster than an ArrayList)
     * 
     * 
     *    capacity will always equal size
     * 
     *    Java linked-lists are ALWAYS doubly linked
     *      2 pointers in each node, one for next node and one for previous
     */

     LinkedList<String> names = new LinkedList<>();
     
     names.add("Austin");
     names.add("Caroline");

     System.out.println(names.get(0));

     // all the same methods as ArrayList
    
   }
}
