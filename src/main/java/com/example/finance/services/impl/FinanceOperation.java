package com.example.finance.services.impl;


import com.example.finance.api.FinanceSettelement;
import com.example.finance.model.Finance;
import com.example.finance.repository.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FinanceOperation implements FinanceSettelement {

    @Autowired
    FinanceRepository financeRepository;

    @Override
    public ArrayList<Finance> displayByBillId(String referenceId) {
        return financeRepository.findByBillid(referenceId);
    }

    @Override
    public String addPurchaseFinance(Finance finance) {
        Finance financecSave = financeRepository.save(finance);

        System.out.print("\n<-----------Your reference id : "+financecSave.billid+"-------------->\n");
        return("Successfully added \n Your reference id : "+financecSave.billid);
    }


    @Override
    public String calculateFinance(String referenceId, int dueAmount) {
        int id = 0;
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        ArrayList<Finance> financesByReferenceId = financeRepository.findByBillid(referenceId);
        for(Finance fin: financesByReferenceId){  id = fin.getId();break;}
        Finance fetchFinanceDetails = financeRepository.findById(id);

        double due= financesByReferenceId.stream()
                .mapToDouble(Finance::getDue_amount)
                .min()
                .getAsDouble();

        System.out.print("NO DUE AMOUNT"+due);

        if(due==0){
            return("NO DUE AMOUNT");
        }
        else if(due<dueAmount){

            Finance financeSave = new Finance(1,referenceId,fetchFinanceDetails.getType(),fetchFinanceDetails.getBuyer_id(),fetchFinanceDetails.getSeller_id(), fetchFinanceDetails.getProduct_id(),fetchFinanceDetails.getTotal_bill_amount(),0, date);
            financeRepository.save(financeSave);
            return ("Successfully added the transaction and you have repaid the entire due");
        }
        else{
            due-=dueAmount;
            Finance financeSave = new Finance(1,referenceId,fetchFinanceDetails.getType(),fetchFinanceDetails.getBuyer_id(),fetchFinanceDetails.getSeller_id(),fetchFinanceDetails.getProduct_id() ,fetchFinanceDetails.getTotal_bill_amount(),due, date);
            financeRepository.save(financeSave);
            return("Successfully paid the due. you have pending due yet");

        }

    }

//    @Override
//    public String calculateFinance()
}
