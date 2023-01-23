package com.example.finance.kafka;


import com.example.finance.model.CalFinace;
import com.example.finance.model.Finance;
import com.example.finance.services.impl.FinanceOperation;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListeners {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    FinanceOperation financeOp;

    @KafkaListener(topics = "SEND.FINANCE.INFO", groupId = "transactions")
    public void getFinancetDetail(ConsumerRecord<?,String> consumerRecord){
        Finance finance = null;
        try{
            finance = objectMapper.readValue(consumerRecord.value(), new TypeReference<Finance>() {
            });
            financeOp.addPurchaseFinance(finance);

        }catch(Exception e){
            System.out.print(e);
        }
        System.out.print("\n\n--------------------->"+finance.getBillid()+" "+finance.getBillid()+" "+finance.getProduct_id());
    }

    @KafkaListener(topics = "SEND.DUE.INFO", groupId = "transactions")
    public void getDueDetail(ConsumerRecord<?,String> consumerRecord){
        CalFinace calFinance = null;
        try{
            System.out.print("\n<-------------"+consumerRecord.value()+"-------------->\n");
            calFinance= objectMapper.readValue(consumerRecord.value(), new TypeReference<CalFinace>() {
            });
            financeOp.calculateFinance(calFinance.billid, calFinance.dueAmount);

        }catch(Exception e){
            System.out.print(e);
        }
    }

}
