/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apptivate.OptIn.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ClientBranchExtended implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int serial;
    private String code;
    private String physicalAddress;
    private String postalAddress;
    private String postalCode;
    private String phoneNumber;
    private String emailAddress;
    @Transient
    private boolean opened;

    @JoinColumn(name = "country", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private Country country;
    @JoinColumn(name = "city", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private City city;
    @JoinColumn(name = "region", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Region region;
    private int authorizationLevels;
    @JoinColumn(name = "branch_category", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private BranchCategory branchCategory;
    @JoinColumn(name = "bank", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private Bank bank;
    @JoinColumn(name = "bank_branch", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private BankBranch bankBranch;
    private String accountName;
    private String accountNumber;
    @JoinColumn(name = "client", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Client client;
    @JoinColumn(name = "identity_doc", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private IdentityDoc identityDoc;
    private String certificateNumber;
    private Double latitude;
    private Double longitude;
    private String correlator;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastUpdated;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;
    private int createdBy;
    @JoinColumn(name = "branch_type", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private BranchType branchType;
    @JoinColumn(name = "status", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private Status status;
    @JoinColumn(name = "settlement_type", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private SettlementType settlementType;
    private int approvedBy;
    private Date approvedDate;
    @Column(name = "delivery")
    private boolean doDelivery;
    @Column(name = "logo_url")
    private String logo;
    private double distance;
    private double radius;
    private String day;
    private String openTime;
    private String closeTime;
}
