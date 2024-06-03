package com.mcb.billing.controller;

import com.mcb.billing.dto.BillDto;
import com.mcb.billing.entity.Bill;
import com.mcb.billing.repository.BillRepository;
import com.mcb.billing.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private BillRepository billRepository;


    // Build add bill REST API
    @PostMapping("/addBill")
    public ResponseEntity<BillDto> createBill(@RequestBody BillDto billDto)
    {
        BillDto billDto1 = billService.createBill(billDto);
        return new ResponseEntity<>(billDto1, HttpStatus.CREATED);
    }

    // Build Assign Bill TO user REST API
    @PostMapping("/assignBill")
    public ResponseEntity<String> assignBill(@RequestParam Integer meterNumber,@RequestParam Integer billNumber)
    {
        Bill bill = billRepository.findByBillNo(billNumber);
        billService.assignBillToUser(meterNumber,bill);
        return new ResponseEntity<>("Successfully Assign!",HttpStatus.OK);
    }


    // Build Get ALL Bills REST API
    @GetMapping("/getAllBills")
    public ResponseEntity<List<BillDto>> getAllBills()
    {
        List<BillDto> billDtoList = billService.getAllBills();

        return new ResponseEntity<>(billDtoList,HttpStatus.OK);
    }

    @DeleteMapping("/deleteBillByBillNumber/{number}")
    public ResponseEntity<String> deleteBill(@PathVariable Integer number)
    {
        billService.deleteBillByNumber(number);
        return new ResponseEntity<>("Bill Deleted Successfully!",HttpStatus.OK);
    }


}
