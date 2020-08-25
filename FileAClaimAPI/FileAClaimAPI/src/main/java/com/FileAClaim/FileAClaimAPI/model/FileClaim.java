package com.FileAClaim.FileAClaimAPI.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "claimdetails")
public class FileClaim {
    @Id
    @GeneratedValue
    @Column(name = "claim_id")
    private int claim_id;

    @Column(name = "customer_id")
    private String customer_id;

    @Column(name = "policy_number")
    private String policy_number;

    @Column(name = "claim_status")
    private String claim_status;

    @Column(name = "file")
    @Lob
    private byte[] file;

    @Column(name = "file_name")
    private String file_name;

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public FileClaim(byte[] bytes, String customer_id, String policy_number) {
        this.file = bytes;
        this.customer_id = customer_id;
        this.policy_number = policy_number;
    }

    public FileClaim() {

    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public int getClaim_id() {
        return claim_id;
    }

    public void setClaim_id(int claim_id) {
        this.claim_id = claim_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
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
}

