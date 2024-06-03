package com.mcb.billing.repository;

import com.mcb.billing.dto.UserDto;
import com.mcb.billing.entity.Bill;
import com.mcb.billing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill , Long> {



    @Query("SELECT u FROM Bill u where billNumber =:billNumber")
    Bill findByBillNo(@Param("billNumber") Integer billNumber);

    @Query(value = "SELECT * FROM bills",nativeQuery = true)
    List<Bill> getAllBills();

    @Query(value = "DELETE FROM bills WHERE billNumber =:number",nativeQuery = true)
    void deleteBillByNo(@Param("number")Integer number);


    
}
