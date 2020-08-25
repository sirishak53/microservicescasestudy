package com.premiumpayment.PremiumPaymentAPI.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transactiondetails")
public class PaymentRequest implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "transaction_id")
    private int transactionId;

    @Column(name = "transaction_amount")
    private String transaction_amount;

    @Column(name = "transaction_date")
    private String transaction_date;

    @Column(name = "transaction_status")
    private String transaction_status;

    @Column(name = "customer_id")
    private String customer_id;

    public PaymentRequest(String customer_id, String transaction_amount, String transaction_date) {
        this.customer_id = customer_id;
        this.transaction_amount = transaction_amount;
        this.transaction_date = transaction_date;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "transactionId=" + transactionId +
                ", transaction_amount='" + transaction_amount + '\'' +
                ", transaction_date='" + transaction_date + '\'' +
                ", transaction_status='" + transaction_status + '\'' +
                ", customer_id='" + customer_id + '\'' +
                '}';
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(String transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getTransaction_status() {
        return transaction_status;
    }

    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
}
