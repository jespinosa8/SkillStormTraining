package com.skillstorm.springmvc.services;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.springmvc.dtos.UserDto;
import com.skillstorm.springmvc.mappers.UserMapper;
import com.skillstorm.springmvc.models.User;

@Service    //sterotype annotation for @Component
public class UserService {


  /*
   * all business logic for controllers and repositories
   * 
   * 
   * for this example, I'm simulating getting data back
   *    IN PRACTICE - you'd want to call your repository
   * 
   */
  
  //  public List<User> findAllUsers() {
  //   List<User> users = new LinkedList<>();   
    
  //   users.add(new User(0, "Austin", "Reeves", "areeves@skillstorm", "veryStrongPassword"));
  //   users.add(new User(0, "Calin", "Blauth", "cblauth@skillstorm", "veryStrongPassword"));
  //   users.add(new User(0, "Jordan", "Espinosa", "jespinosa@skillstorm", "veryStrongPassword"));
  //   users.add(new User(0, "Chris", "Beherens", "cbehrens@skillstorm", "veryStrongPassword"));

  //   return users;
  //  }

  //@Autowired
  //UserRepository repository;

  @Autowired
  UserMapper mapper;

  public List<UserDto> findAllUsers() {
    List<User> users = new LinkedList<>();   
    
    users.add(new User(0, "Austin", "Reeves", "areeves@skillstorm", "veryStrongPassword"));
    users.add(new User(1, "Calin", "Blauth", "cblauth@skillstorm", "veryStrongPassword"));
    users.add(new User(2, "Jordan", "Espinosa", "jespinosa@skillstorm", "veryStrongPassword"));
    users.add(new User(3, "Chris", "Beherens", "cbehrens@skillstorm", "veryStrongPassword"));

    // converting list<user> to Stream<User>. Then converting Stream<User> to Stream<UserDto>. Then Stream<UserDto> to List<UserDto>
    List<UserDto> userDtos = users.stream().map(mapper::toDto).collect(Collectors.toList());
    return userDtos;
   }


   public List<User> findUsersByFirstName(String name) {
    List<User> users = new LinkedList<>();   
    
    users.add(new User(0, name, "Reeves", "areeves@skillstorm", "veryStrongPassword"));
    users.add(new User(1, name, "Blauth", "cblauth@skillstorm", "veryStrongPassword"));
    users.add(new User(2, name, "Espinosa", "jespinosa@skillstorm", "veryStrongPassword"));
    users.add(new User(3, name, "Beherens", "cbehrens@skillstorm", "veryStrongPassword"));

    return users;
   }

   public User findById(long id) {
    return new User(id, "Austin", "Reeves", "areeves@skillstorm", "veryStrongPassword");
   }

   public User createUser(User user) {
    user.setId(1000);
    return user;
   }

   public User updateUser(long id, User user) {
    user.setId(id);
    return user;
   }

   public User deleteUser(long id, User user) {    
    return user;
   }

}
