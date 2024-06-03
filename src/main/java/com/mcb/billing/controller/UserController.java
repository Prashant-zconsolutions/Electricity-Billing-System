package com.mcb.billing.controller;

import com.mcb.billing.dto.UserDto;
import com.mcb.billing.entity.User;
import com.mcb.billing.repository.UsersRepository;
import com.mcb.billing.service.UserService;
import com.mcb.billing.utils.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UsersRepository usersRepository;


    // Build Add User REST API
    @PostMapping("/addUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
       UserDto saveUserDto =  userService.createUser(userDto);
       return new ResponseEntity<>(saveUserDto, HttpStatus.CREATED);
    }
    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserDto>> getAllUser()
    {
        List<UserDto> list = userService.getAllUser();
        return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
    }

    // Build Get User By ID REST API
    @GetMapping("/getUserBymeterNo/{number}")
    public ResponseEntity getUserById(@PathVariable Integer number)
    {
        UserDto userDto =  userService.getUserById(number);
        return new ResponseEntity(userDto,HttpStatus.OK);

    }

    // Build Get User By Email REST API
    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email)
    {
        User user =  usersRepository.findByEmail(email); // used user repository to call method
        UserDto userDto = UserConverter.convertToUserDto(user);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

    // Build Delete User By Meter Name REST API
    @DeleteMapping("/deleteUser/{meterNumber}")
    public ResponseEntity<String> deleteUserByMeterNo(@PathVariable Integer meterNumber)
    {
       userService.deleteUserById(meterNumber);
       return new ResponseEntity<>("User Deleted! "+meterNumber,HttpStatus.OK);
    }

    // Build update User REST API
    @PutMapping("/updateUser/{meterNumber}")
    public ResponseEntity<UserDto> updateUserByMeterNo(@PathVariable("meterNumber") Integer meterNumber,
                                                       @RequestBody UserDto userDto){
        UserDto dto = userService.updateUser(meterNumber,userDto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/dis")
    public ResponseEntity<String> display()
    {
        return new ResponseEntity<>("Hello Prashant",HttpStatus.OK);
    }

}
