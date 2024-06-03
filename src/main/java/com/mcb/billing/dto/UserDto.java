package com.mcb.billing.dto;

import com.mcb.billing.entity.Bill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer meterNumber;
    private String userFirstName;
    private String userLastName;
    private String email;
    private String address;
    private String city;
    private String state;
    private String userType;
    private String userPhoneNumber;

    private List<Bill> billList;



}
