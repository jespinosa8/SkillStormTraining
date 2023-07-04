package Java.Day2.DesignPatterns.ProducerConsumer;

import java.util.Queue; 
import java.util.concurrent.ConcurrentLinkedQueue;

/*
 * PRODUCER CONSUMER
 *    one entity (usually a thread) produces (generate/receive/read in) data
 *    another entity (usually a thread) consumes that data (process/manage/manipulate)
 * 
 *    use multithreading in java to do this 
 * 
 */


public class ProducerConsumer {
  
  public static void main(String[] args) {
    
    /*
     * CONCURRENT COLLECTIONS
     *    java.util.concurrent
     *    thread-safe collections
     *      handles synchronization for us 
     *    
     *    queues are FIFO
     */

    final Queue<Integer> buffer = new ConcurrentLinkedQueue<>();    // the size of the collection will never change
    final int CAPACITY = 5;                                         // final means the value cannot be changed - capacity will always be 5



    Thread producerThread = new Thread(new Runnable() {
      /*
       * ANONYMOUS INNER CLASS
       *    a class that isn't declared but it is defined
       * 
       *    only created with functional interface
       * 
       */

       @Override
      public void run() {
      
        int value = 0;
        while(true) {
          if(buffer.size() < CAPACITY) {
            System.out.println("producer produces: " + value);
            buffer.add(value++);
          }
        }
      }

    });

    /*
     * LAMBDA FUNCTIONS
     *    shorthand to implement the *method* of a functional interface
     * 
     */
    Thread consumerThread = new Thread( (/* any parameters from the method */) -> {

      // THIS IS THE RUN METHOD FROM THE RUNNABLE CLASS

      while(true) {
        if(!buffer.isEmpty()) {
          int value = buffer.poll();    // poll - retrieving the data at the front of the queue and removing it from the queue
          System.out.println("Consumer consumes: " + value);
        }
      }
    });

    producerThread.start();
    consumerThread.start();

  }
}
