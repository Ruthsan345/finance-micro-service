package com.example.finance.repository;

import com.example.finance.model.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface FinanceRepository extends JpaRepository<Finance, Integer> {
    Finance findById(int Id);
    ArrayList<Finance> findByBillid(String billId);

//    ArrayList<WholesalerInventory> findByWholesalerid(int wholesalerId);
}
