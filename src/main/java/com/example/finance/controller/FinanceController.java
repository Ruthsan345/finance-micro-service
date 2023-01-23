package com.example.finance.controller;


import com.example.finance.api.FinanceSettelement;
import com.example.finance.exception.UserDefinedException;
import com.example.finance.model.Finance;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("wholesaler/api/")
@RestController()
public class FinanceController {
    @Autowired
    FinanceSettelement financeOp;

//    @PostMapping("/generatePDFBill")
//    public ResponseEntity<String> generatePDFBill(@RequestBody Bill bill) {
//        billingOp.generatePDFBill(bill);
//        return new ResponseEntity<>("Bill generation success", HttpStatus.OK);
//    }
//
//    @PostMapping("/sendInvoiceMail")
//    public ResponseEntity<String> sendInvoiceMail(@RequestParam String invoiceId, @RequestParam String mailId, @RequestParam Boolean isWholesaler) {
//        billingOp.sendInvoiceMail(invoiceId, mailId, isWholesaler);
//        return new ResponseEntity<>("Mail sent successfully", HttpStatus.OK);
//    }

    @GetMapping("/displayByBillId")
    public ResponseEntity<ArrayList<Finance>>displayByBillId(@RequestParam String billId) {
        try { return new ResponseEntity<>(financeOp.displayByBillId(billId), HttpStatus.OK); }
        catch(Exception e){ return new ResponseEntity("Error while displaying the particular transaction",HttpStatus.BAD_REQUEST); }
    }


    @PostMapping("/addPurchaseFinance")
    public ResponseEntity<String> addPurchaseFinance(@RequestBody Finance finance) {
        try { return new ResponseEntity<>(financeOp.addPurchaseFinance(finance),HttpStatus.OK); }
        catch(Exception e){ return new ResponseEntity("Error while adding the particular transaction",HttpStatus.BAD_REQUEST); }
    }

    @PostMapping("/calculateFinance")
    public ResponseEntity<String> calculateFinance(@RequestParam String billId, @RequestParam int dueAmount ) {

        try { return new ResponseEntity<>(financeOp.calculateFinance(billId, dueAmount),HttpStatus.OK); }
        catch(Exception e){ return new ResponseEntity("Error while adding the particular transaction",HttpStatus.BAD_REQUEST); }
    }

}


