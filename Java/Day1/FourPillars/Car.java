package Java.Day1.FourPillars;

public class Car extends Vehicle {
  

  /*
   * 
   *  ENCAPSULATION
   *    - wrapping up related state and havior into a single class
   *    - then we can control how that state and behavior is modified and accessed
   *       - access modifiers 
   *         - public: everyone can see
   *         - private: only the class can see
   *         - protected: only the package can see 
   */

   // properties of our class 
   private String engine;
   private String make;
   private String model;

  // no arg constructor
  // implicitly defined by Java if you don't declare
  public Car() {
    
  }

  // parameterized constructor 
  public Car(String engine, String make, String model, String type, int numWheels) {
    super(type, numWheels);

    this.engine = engine;
    this.make = make;
    this.model = model;
  }

  public String getEngine() {
    return engine;
  }

  public void setEngine(String engine) {
    this.engine = engine;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  /*
   *  POLYMORPHISM
   *    - "many forms"
   * 
   *    - method overrriding 
   *      - happens at runtime
   *      - when you implement a method from the parent class in the child class
   *    
   *    - every class inherits from Object class 
   */

  @Override   // semantics - just a way to show that it is an overidden method
  public String toString() {
    return "Car [engine=" + engine + ", make=" + make + ", model=" + model + "]";
  }

  @Override
  public void start() {
    System.out.println(engine + " is used to drive");
  }

  @Override
  public void drive() {
    System.out.println();
  }  


}
