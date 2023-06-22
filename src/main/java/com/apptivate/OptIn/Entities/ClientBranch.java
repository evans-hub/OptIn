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
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ClientBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String name;
    private int serial;
    private String code;
    private String physicalAddress;
    private String postalAddress;
    private String postalCode;
    private String phoneNumber;
    private String emailAddress;
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
    @JoinColumn(name = "bank", referencedColumnName = "id")
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
    @JoinColumn(name = "parent", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Client parent;
    @JoinColumn(name = "identity_doc", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private IdentityDoc identityDoc;
    private String certificateNumber;
    private Double latitude;
    private Double longitude;
    private String correlator;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateLastUpdated;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
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

    private String workingHours;
    @Column(name = "delivery")
    private boolean doDelivery;

    @Column(name = "logo_url")
    private String logo;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "logo")
    private byte[] data;
    private String qrCode;
    private Integer jpCorrelator;

    public ClientBranch(Integer id) {
        this.id = id;
    }

}
