package com.example.finance.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Finance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Finance(int id, String billid, String type, int buyer_id, int seller_id, int product_id, float total_bill_amount, double due_amount, Date date) {
        this.id = id;
        this.billid = billid;
        this.type = type;
        this.buyer_id = buyer_id;
        this.seller_id = seller_id;
        this.product_id = product_id;
        this.total_bill_amount = total_bill_amount;
        this.due_amount = due_amount;
        this.date = date;
    }

    public int getBuyer_id() {
        return buyer_id;

    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public float getTotal_bill_amount() {
        return total_bill_amount;
    }

    public void setTotal_bill_amount(float total_bill_amount) {
        this.total_bill_amount = total_bill_amount;
    }

    public double getDue_amount() {
        return due_amount;
    }

    public void setDue_amount(double due_amount) {
        this.due_amount = due_amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "billid")
    public String billid;

    @Column(name = "type")
    public String type;

    @Column(name = "buyer_id")
    public int buyer_id;

    @Column(name = "seller_id")
    public int seller_id;

    @Column(name = "product_id")
    public int product_id;

    @Column(name = "total_bill_amount")
    public float total_bill_amount;

    @Column(name = "due_amount")
    public double due_amount;

    @Column(name = "date", columnDefinition = "DATE")
    public java.sql.Date date;


}
