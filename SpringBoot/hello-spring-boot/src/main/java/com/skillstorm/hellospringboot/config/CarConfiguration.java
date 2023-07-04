package com.skillstorm.hellospringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.skillstorm.hellospringboot.beans.Car;
import com.skillstorm.hellospringboot.beans.ElectricEngine;
import com.skillstorm.hellospringboot.beans.Engine;
import com.skillstorm.hellospringboot.beans.GasEngine;
import com.skillstorm.hellospringboot.beans.Vehicle;

@Configuration
public class CarConfiguration {

/*
 * where we can configure our car beans
 * 
 *    telling spring boot where to get our beans from/how to initialize them
 * 
 */

 /*
  * @Bean
      - register the bean inside the BeanFactory


    @Scope - tells spring what kind of bean you want
      BEAN SCOPES:
        singleton - each bean will be the same (this is the default if you don't specify a new one) **
        prototype - each bean will be different (more-or-less the opposite of a singleton) **
        application - creates a bean for the entire app
        request - creates a bean for the lifespan of an HTTP request
        session - creates a bean for the lifespan of a user's session
        websocket - creates a bean for the lifespan of a websocket
      
  */

 @Bean(name = {"mustang", "camaro"})
 @Scope("prototype")
 public Vehicle gasCar() {
  Car car = new Car();
  car.setEngine(gasEngine());   // setter injection
  
  return car;
 }

 @Bean(name = "tesla")
 @Scope("singleton")    // default bean scope
 public Vehicle electricCar() {
  Car car = new Car(electricEngine());  // constructor injection
  return car;
 }

 @Bean
 public Engine gasEngine() {
  return new GasEngine();
 }
 
 @Bean
 public Engine electricEngine() {
  return new ElectricEngine();
 }
}
