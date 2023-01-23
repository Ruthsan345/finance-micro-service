package com.example.finance.api;


import com.example.finance.model.Finance;

import java.util.ArrayList;

public interface FinanceSettelement {


    ArrayList<Finance> displayByBillId(String billId);

    String addPurchaseFinance(Finance finance);

    String calculateFinance(String billId, int dueAmount);
}
