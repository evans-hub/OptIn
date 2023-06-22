/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apptivate.OptIn.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author david
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ClientFee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @JoinColumn(name = "client", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Client client;
    @JoinColumn(name = "fee", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Fee fee;

    @JoinColumn(name = "status", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private Status status;
    @Column(name = "is_vat")
    private boolean vat;
    private double value;
    @JsonIgnore
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreated;
    @JsonIgnore
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateLastUpdated;
    @JsonIgnore
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateDeleted;
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private User createdBy;

    @JsonIgnore
    @JoinColumn(name = "client_branch", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private ClientBranch clientBranch;
    @Column(name = "is_slabbed")
    private boolean slabbed;

    @JoinColumn(name = "slab_type", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private SlabType slabType;

    @JoinColumn(name = "wallet", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private Wallet wallet;
    private String correlator;

    public ClientFee(Integer id) {
        this.id = id;
    }


}
