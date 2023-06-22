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
public class ClientWalletProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonIgnore
    @JoinColumn(name = "client_wallet_category", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClientWalletCategory clientWalletCategory;

    @JoinColumn(name = "client_wallet", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClientWallet clientWallet;

    @JoinColumn(name = "product", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product product;
    private double unitCost;
    private String name;

    @JsonIgnore
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreated;
    @JsonIgnore
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateLastUpdated;
    @JsonIgnore
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateDeleted;
    @JsonIgnore
    private int createdBy;

    public ClientWalletProduct(Integer id) {
        this.id = id;
    }

}
