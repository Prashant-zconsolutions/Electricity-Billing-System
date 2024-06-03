package com.mcb.billing.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer meterNumber;

    @Column(name = "first_name",nullable = false)
    private String userFirstName;

    @Column(name = "last_name",nullable = false)
    private String userLastName;

    @Column(name = "user_email",nullable = false)
    private String email;

    @Column(name = "user_address",nullable = false)
    private String address;

    @Column(name = "user_city")
    private String city;

    @Column(name = "user_state")
    private String state;

    @Column(name = "user_type",nullable = false)
    private String userType;

    @Column(name = "user_phoneNumber",nullable = false)
    private String userPhoneNumber;


    @OneToMany
    @JoinColumn(name = "meterNumber")
    List<Bill> billList;



//    @OneToMany(targetEntity = Bill.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "ub_fk",referencedColumnName = "meterNumber")
//    List<Bill> billList;



}
