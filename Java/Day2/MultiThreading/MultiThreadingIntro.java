package Java.Day2.MultiThreading;

public class MultiThreadingIntro {
  

  /*
   * MULTI-THREADING
   *    splitting different tasks onto multiple thread to be done concurrently
   *    by default we have the single Main Thread that gets run
   * 
   * 
   *    Doing your laundry
   *      washer -> dryer -> fold
   *        no sense in waiting for one load to be folded before putting a 2nd in the washer
   * 
   *    trade-off: performance speed vs power/resource usage
   * 
   *    
   *    THREAD STATES
   *       1. NEW - created but not yet started (new Thread())
   *       2. RUNNABLE - thread has started (thread.start())
   *       3. BLOCKED - thread is waiting on some lock before continuing 
   *       4. WAITING - thread idle indefinitely (thread.join() or thread .wait())
   *       5. TIMED-WAITING - thread waiting for a specified amount of time (thread.join(3000))
   *       6. TERMINATED - thread is finished
   */

  public static void main(String[] args) {

    // System.out.println(Thread.currentThread().getName());  // reference to main thread

    // creating instances of the runnable class
    RunnableTask task1 = new RunnableTask("Task1");
    RunnableTask task2 = new RunnableTask("Task2");
    RunnableTask task3 = new RunnableTask("Task3");

    // using Thread class to make our threads
    // these threads are in the NEW state
    Thread thread1 = new Thread(task1);
    Thread thread2 = new Thread(task2);
    Thread thread3 = new Thread(task3);

    // using .start() to make threads run
    // this puts them into the RUNNABLE state
    thread1.start();
    thread2.start();
    thread3.start();  

    try {

      // .join() telling the Main Thread to wait for thread1 before it finishes
      // this puts the MAIN Thread into a WAITING state  until thread1 enters TERMINATED state
      thread1.join();
    } catch (InterruptedException e) {      
      e.printStackTrace();
    }

  }
}


/*
 * RUNNABLE INTERFACE
 *    a functional interface for defining how threads will run
 *      functional interface - an interface with one method
 * 
 */

 class RunnableTask implements Runnable {
  
  private String taskName;

  

  public RunnableTask(String taskName) {
    this.taskName = taskName;
  }


  // run() is where you define what the thread will do while it's running
  @Override
  public void run() {
    System.out.println("Task " + taskName + " is running in the Thread " + Thread.currentThread().getName());    

   try {
        Thread.sleep(2000);   // thread waits for 2 secs

   } catch (Exception e) {
    e.printStackTrace();
   }

   System.out.println("Task " + taskName + " has finished!");
  }
 }
