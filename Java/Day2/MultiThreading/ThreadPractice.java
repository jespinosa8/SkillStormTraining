package Java.Day2.MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPractice {
  
  /*
   * every thread has its own stack 
   *    so things like methods and instance variables, each thread will have its own copy of 
   * 
   *    volatile - keyword to give synchornization across threads
   *      won't block other threads from manipulating the variable
   * 
   *    static - means that there is only 1 reference in memory
   */

  private static volatile int count = 0;
  /*
   * ATOMIC VALUES
   *    basically means "All at once" and "all or none"
   * 
   * 
   *    AtomicInteger, AtomicDouble, etc.
   *      creates Thread-safe versions of the primitive type
   * 
   * 
   *    all methods in Java are atomic by default
   * 
   * ** cant reference a non-static variable outside of a static method
   * 
   * 
   */

  private static AtomicInteger atomicCount = new AtomicInteger(0);
  
  public static void increment() {
    count++;
    atomicCount.incrementAndGet();    // ++atomicCount vs atomicCount++
  }

  public static void main(String[] args) {
    
    // creating two threads that will loop 100000000 times
    CustomThread t1 = new CustomThread(100000000);
    CustomThread t2 = new CustomThread(100000000);

    // expecting result: count and atomicCount should be 200000000
    
    t1.start();
    t2.start();

    // this isn't synchornized so it is not likely to be up to date
    System.out.println("Current count is " + count);

    try {
      
      // telling main to wait for these threads to finish
      t1.join();
      t2.join();
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("Total count is " + count);
    System.out.println("Total atomicCount is " + atomicCount);


    /*
     * CONCURRENCY ISSUES
     *    lost update - when a variable is updated, but is then changed immediately after by something else
     * 
     * 
     */
  }


}

class CustomThread extends Thread {
  
  private int loopAmount;

  public CustomThread(int loopAmount) {
    this.loopAmount = loopAmount;
  }

  @Override
  public void run() {
    for(int i = 0; i < loopAmount; i++) {
      ThreadPractice.increment();
    }
  }

}
