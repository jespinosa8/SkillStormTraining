package com.skillstorm.springmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.springmvc.dtos.UserDto;
import com.skillstorm.springmvc.models.User;
import com.skillstorm.springmvc.repositories.UserRepository;
import com.skillstorm.springmvc.services.UserService;



/*
 * Controller vs RestController
 *    RestController implicitly adds @ResponseBody to every method in the class
 *      @ResponseBody will tell the controller that the object returned is serialized into JSON inside the body of the HTTP response
 *  
 */
@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  UserService service;

  /*
   * GET - retrieve data
   * POST - create data
   * PUT  - update data
   * DELETE - delete data
   * 
   * 
   */

  // @Autowired 
  // UserRepository repository;
  
  // the actual path for the http request will be /users/helloworld
  @RequestMapping("/helloworld")
  public String helloWorld() {
    return "Hello World!";
  }

  /*
   * GetMapping is an HTTP GET request
   *    same as RequestMapping(method = RequestMethod.GET)
   * 
   * 
   */
  @GetMapping   // no path specified - means it'll just be /users
  public List<UserDto> findAllUsers() {
    return service.findAllUsers();
  }

  /*
   * @RequestParam
   *    finds the data for the parameter in the url path
   * 
   *    /users/firstName?name=[data]
   * 
   *    variable name in path must match string past into method
   * 
   */
  @GetMapping("/first_name")
  public List<User> findbyFirstName(@RequestParam String firstName) {
    return service.findUsersByFirstName("Austin");
  }



  /*
   * @PathVariable
   *    finds the data for the parameter in the url path
   * 
   *    /users/user/[data]
   */
  @GetMapping("/user/{id}")
  public User findById(@PathVariable long id) {
    return service.findById(id);
  }

  /*
   * ResponseEntity - give you more control over your response
   *    - modify headers, status codes, etc
   *    
   * @RequestBody - look for the data in the body of the request
   *    - deserializes JSON to java object
   * 
   */
  @PostMapping("/user")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User createdUser = service.createUser(user);
    return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);   // sets the status code to 201 - Created
  } 

  @PutMapping("/user/{id}")
  public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
    User updatedUser = service.updateUser(id, user);
    return new ResponseEntity<User>(updatedUser, HttpStatus.OK);   // sets the status code to 200 - OK
  }

  @DeleteMapping("/user/{id}")
  public ResponseEntity<User> deleteUser(@PathVariable long id, @RequestBody User user) {
    service.deleteUser(id, user);
    return new ResponseEntity<User>(HttpStatus.NO_CONTENT);   // sets the status code to 204 - No Content
  }

}
