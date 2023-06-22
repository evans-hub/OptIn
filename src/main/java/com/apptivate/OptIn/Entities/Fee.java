/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apptivate.OptIn.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author david
 */
@NoArgsConstructor
@Data
@Entity
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @JoinColumn(name = "fee_type", referencedColumnName = "code")
    @ManyToOne
    private FeeType feeType;
    private String description;
    @JoinColumn(name = "frequency", referencedColumnName = "code")
    @ManyToOne
    private Frequency frequency;
    @JoinColumn(name = "value_type", referencedColumnName = "code")
    @ManyToOne
    private ValueType valueType;
    @Column(name = "is_slabbed")
    private boolean slabbed;
    @JoinColumn(name = "slab_type", referencedColumnName = "code")
    @ManyToOne
    private SlabType slabType;
    @JoinColumn(name = "client_type", referencedColumnName = "code")
    @ManyToOne
    private ClientType clientType;
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private User createdBy;
    private String correlator;
    private double value;
    @Column(name = "is_assignable")
    private boolean assignable;
    @Column(name = "is_vat")
    private boolean vat;
    @Column(name = "is_tax")
    private boolean tax;

    @JoinColumn(name = "settlement_type", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private SettlementType settlementType;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastUpdated;
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;

    public Fee(Integer id) {
        this.id = id;
    }

}
