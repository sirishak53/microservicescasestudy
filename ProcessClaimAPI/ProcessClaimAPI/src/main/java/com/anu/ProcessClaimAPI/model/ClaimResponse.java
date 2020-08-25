package com.anu.ProcessClaimAPI.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "claimdetails")
@NoArgsConstructor
@AllArgsConstructor
public class ClaimResponse implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "claim_id")
    private int claim_id;

    @Column(name = "customer_id")
    private int customer_id;

    @Column(name = "policy_number")
    private String policy_number;

    @Column(name = "claim_status")
    private String claim_status;
//
//    @Column(name = "email_notification")
//    private String email_notification;

    @Column(name = "file_name")
    private String file_name;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getPolicy_number() {
        return policy_number;
    }

    public void setPolicy_number(String policy_number) {
        this.policy_number = policy_number;
    }

    public String getClaim_status() {
        return claim_status;
    }

    public void setClaim_status(String claim_status) {
        this.claim_status = claim_status;
    }

//    public String getEmail_notification() {
//        return email_notification;
//    }
//
//    public void setEmail_notification(String email_notification) {
//        this.email_notification = email_notification;
//    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }
}
