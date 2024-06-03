package com.mcb.billing.serviceImpl;

import com.mcb.billing.dto.BillDto;
import com.mcb.billing.entity.Bill;
import com.mcb.billing.entity.User;
import com.mcb.billing.exception.ResourceNotFoundException;
import com.mcb.billing.repository.BillRepository;
import com.mcb.billing.repository.UsersRepository;
import com.mcb.billing.service.BillService;
import com.mcb.billing.utils.BillConverter;
import com.mcb.billing.utils.Rates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public BillDto createBill(BillDto billDto) {

        Bill bill = BillConverter.convertToBillEntity(billDto);
        Bill saveBill =  billRepository.save(bill);
        return BillConverter.convertToBillDto(saveBill);

    }

    @Override
    public void assignBillToUser(Integer number, Bill bill) {
        User user = usersRepository.getUserById(number);
        if (user != null)
        {
            String s = user.getUserType();
            if (s.equalsIgnoreCase("home"))
                bill.setBillAmount(bill.getBillUnit() * (Rates.homeRate));
            if (s.equalsIgnoreCase("commercial"))
                bill.setBillAmount(bill.getBillUnit() * (Rates.industrialRate));

           bill.setUser(user);
           billRepository.save(bill);
        }
        else
        {
            throw new ResourceNotFoundException("User is not exist with given meter number : "+number);
        }
    }

    @Override
    public void deleteBillByNumber(Integer number) {

        try {
            billRepository.deleteBillByNo(number);
        }catch (Exception ex)
        {
            throw new ResourceNotFoundException("Bill is not exist with given Bill number : "+number);
        }

    }

    @Override
    public List<BillDto> getAllBills() {

        List<Bill> billList = billRepository.getAllBills();
        List<BillDto> billDtos = billList.stream()
                .map(BillConverter::convertToBillDto)
                .collect(Collectors.toList());

        return billDtos;

    }
}
