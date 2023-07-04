package com.skillstorm.springmvc.mappers;

import org.springframework.stereotype.Component;

import com.skillstorm.springmvc.dtos.UserDto;
import com.skillstorm.springmvc.models.User;

/*
 * converts UserDto to User and vice versa
 * 
 */

@Component
public class UserMapper {
  

  public User toUser(UserDto dto) {
    return new User(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail());
  }

  public UserDto toDto(User user) {
    return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
  }
}
