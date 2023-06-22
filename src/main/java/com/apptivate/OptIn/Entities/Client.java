/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apptivate.OptIn.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Client implements Serializable {
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
    @JoinColumn(name = "client_type", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private ClientType clientType;
    @JoinColumn(name = "country", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private Country country;
    @JoinColumn(name = "city", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private City city;
    @JoinColumn(name = "region", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Region region;
    @JoinColumn(name = "business_type", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private BusinessType businessType;
    @JoinColumn(name = "category", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private Category category;
    @JoinColumn(name = "bank", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Bank bank;
    @JoinColumn(name = "bank_branch", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private BankBranch bankBranch;
    private String accountName;
    private String accountNumber;
    @JoinColumn(name = "status", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private Status status;
    @JoinColumn(name = "identity_doc", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private IdentityDoc identityDoc;
    private String certificateNumber;
    private String correlator;

    @Column(name = "logo_url")
    private String logo;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "logo")
    private byte[] data;

    @JoinColumn(name = "settlement_at", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private SettlementAt settlementAt;

    @JoinColumn(name = "settlement_type", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private SettlementType settlementType;

    @JoinColumn(name = "tax_type", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private TaxType taxType;
    private double taxValue;

    private Double latitude;
    private Double longitude;
    private int authorizationLevels;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateLastUpdated;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateDeleted;
    private int createdBy;
    private Integer jpCorrelator;


    @OneToMany(mappedBy = "client")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Order> ordersCollection;

    public Client(Integer id) {
        this.id = id;
    }


}
