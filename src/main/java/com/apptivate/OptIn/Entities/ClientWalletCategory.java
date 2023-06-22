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
import java.util.Collection;
import java.util.Date;

/**
 * @author david
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ClientWalletCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @JoinColumn(name = "client_wallet", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClientWallet clientWallet;
    private String name;
    private int client;
    private int serial;
    private String code;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastUpdated;
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;
    private int createdBy;

    @OneToMany(mappedBy = "clientWalletCategory")
    private Collection<ClientWalletCategoryLimit> clientWalletCategoryLimitCollection;


//    @OneToMany(mappedBy = "clientWalletCategory")
//    private Collection<ClientWalletProduct> clientWalletCategoryProductCollection;

    public ClientWalletCategory(Integer id) {
        this.id = id;
    }


}
