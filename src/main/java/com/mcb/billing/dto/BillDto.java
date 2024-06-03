package com.mcb.billing.dto;

import com.mcb.billing.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {

    private Integer billNumber;
    private LocalDate billDate;
    private Integer billUnit;
    private Float billAmount;


    private User user;

}
