package com.mcb.billing.serviceImpl;

import com.mcb.billing.dto.UserDto;
import com.mcb.billing.entity.User;
import com.mcb.billing.exception.ResourceNotFoundException;
import com.mcb.billing.repository.UsersRepository;
import com.mcb.billing.service.UserService;
import com.mcb.billing.utils.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = UserConverter.convertToUserEntity(userDto);
        User saveUser = usersRepository.save(user);
        return UserConverter.convertToUserDto(saveUser);

    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> userList = usersRepository.getAllUsers();
        List<UserDto> userDtoList = userList.stream()
                .map(UserConverter::convertToUserDto)
                .collect(Collectors.toList());

        return userDtoList;
    }

    @Override
    public UserDto getUserById(Integer number) {
        try {
            User user =  usersRepository.getUserById(number);
            return  UserConverter.convertToUserDto(user);
        }catch (Exception ex)
        {
            throw new ResourceNotFoundException("User is not exist with given meter number : "+number+" \nException : "+ex.getMessage());
        }

    }

    @Override
    public void deleteUserById(Integer number) {
        try {
            usersRepository.deleteUserById(number);
        }catch (Exception ex)
        {
            throw new ResourceNotFoundException("User is not exist with given meter number : "+number);
        }
    }

    @Override
    public UserDto updateUser(Integer number, UserDto userDto) {
        User user = usersRepository.getUserById(number);
        if(user==null)
        {
            throw new ResourceNotFoundException("User is not exist with given meter number : "+number);
        }
        else
        {
            user.setUserFirstName(userDto.getUserFirstName());
            user.setUserLastName(userDto.getUserLastName());
            user.setEmail(userDto.getEmail());
            user.setAddress(userDto.getAddress());
            user.setCity(userDto.getCity());
            user.setState(userDto.getState());
            user.setUserType(userDto.getUserType());
            user.setUserPhoneNumber(userDto.getUserPhoneNumber());

         User updateUser = usersRepository.save(user);
         return UserConverter.convertToUserDto(updateUser);

        }

    }


}
