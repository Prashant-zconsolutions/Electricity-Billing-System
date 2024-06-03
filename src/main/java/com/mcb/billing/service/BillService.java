package com.mcb.billing.service;

import com.mcb.billing.dto.BillDto;
import com.mcb.billing.entity.Bill;

import java.util.List;

public interface BillService {

    BillDto createBill(BillDto billDto);

    void assignBillToUser(Integer number, Bill bill);

    void deleteBillByNumber(Integer number);

    List<BillDto> getAllBills();

}
