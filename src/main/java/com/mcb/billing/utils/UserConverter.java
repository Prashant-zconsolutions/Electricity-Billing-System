package com.mcb.billing.utils;

import com.mcb.billing.dto.UserDto;
import com.mcb.billing.entity.User;

public class UserConverter {

    public static UserDto convertToUserDto(User user)
    {
        return new UserDto(
                user.getMeterNumber(),
                user.getUserFirstName(),
                user.getUserLastName(),
                user.getEmail(),
                user.getAddress(),
                user.getState(),
                user.getCity(),
                user.getUserType(),
                user.getUserPhoneNumber(),
                user.getBillList()
        );
    }

    public static User convertToUserEntity(UserDto userDto)
    {
        return new User(
                userDto.getMeterNumber(),
                userDto.getUserFirstName(),
                userDto.getUserLastName(),
                userDto.getEmail(),
                userDto.getAddress(),
                userDto.getState(),
                userDto.getCity(),
                userDto.getUserType(),
                userDto.getUserPhoneNumber(),
                userDto.getBillList()
        );
    }
}
