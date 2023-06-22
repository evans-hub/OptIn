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
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @author david
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "client_wallet_limit")
public class ClientWalletCategoryLimit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "client_wallet_category", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClientWalletCategory clientWalletCategory;
    @JoinColumn(name = "limit_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Limit limit;
    private int client;
    private String value;
    @JoinColumn(name = "control_type", referencedColumnName = "code")
    @ManyToOne
    private ControlType controlType;
    @JoinColumn(name = "restrict_type", referencedColumnName = "code")
    @ManyToOne
    private RestrictType restrictType;
    @JoinColumn(name = "limit_type", referencedColumnName = "code")
    @ManyToOne
    private LimitType limitType;
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
    @OneToMany(mappedBy = "clientWalletCategoryLimit")
    private Collection<ClientWalletLimitDay> clientWalletCategoryLimitDayCollection;
    @OneToMany(mappedBy = "clientWalletCategoryLimit")
    private Collection<ClientWalletLimitOutlet> clientWalletCategoryLimitOutletCollection;
    @OneToMany(mappedBy = "clientWalletCategoryLimit")
    private Collection<CategoryProduct> categoryProductLimitCollection;

    public ClientWalletCategoryLimit(Integer id) {
        this.id = id;
    }

}
