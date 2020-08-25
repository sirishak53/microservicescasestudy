package com.policy.PremiumsAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "policydetails")
@NoArgsConstructor
@AllArgsConstructor
public class GetPremiumResponse implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "policy_id")
    private int policyId;

    @Column(name = "policy_number")
    private String policyNumber;

    @Column(name = "premium_duedate")
    private String premiumDueDate;

    @Column(name = "premium_amount")
    private String premiumAmount;
}
