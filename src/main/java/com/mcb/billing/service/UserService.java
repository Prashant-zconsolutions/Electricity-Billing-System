package com.mcb.billing.service;

import com.mcb.billing.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUser();
    UserDto getUserById(Integer number);
    void deleteUserById(Integer number);

    UserDto updateUser(Integer number,UserDto userDto);

}
