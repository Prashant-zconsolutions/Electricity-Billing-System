package com.mcb.billing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "bills")
public class Bill {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billNumber;

    @Column(name = "bill_date")
    private LocalDate billDate;

    @Column(name = "bill_unit")
    private Integer billUnit;

    @Column(name = "bill_amount")
    private Float billAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;



}
