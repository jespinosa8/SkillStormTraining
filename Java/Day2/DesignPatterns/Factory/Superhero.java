package Java.Day2.DesignPatterns.Factory;

public interface Superhero {
 
  void activateSuperPower();
  void sayName();
  
}

class CaptainAmerica implements Superhero {

  @Override
  public void activateSuperPower() {
    System.out.println("I can do this all day!");
    
  }

  @Override
  public void sayName() {
    System.out.println("I am Steve Rogers.");    
  }
  
}

class AustinReeves implements Superhero {

  @Override
  public void activateSuperPower() {
    System.out.println("I can be a java guru.");
    
  }

  @Override
  public void sayName() {
    System.out.println("I am Austin.");    
  }
  
}

class IronMan implements Superhero {

  @Override
  public void activateSuperPower() {
    System.out.println("He's rich");
    
  }

  @Override
  public void sayName() {
    System.out.println("I am... Iron Man");    
  }
  
}
