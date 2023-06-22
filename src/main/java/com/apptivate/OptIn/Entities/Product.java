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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author david
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String correlator;
    private String name;
    private String description;
    private double value;

    @Column(name = "is_default")
    private boolean defaultProduct;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateLastUpdated;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateDeleted;

    @JsonIgnore
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User createdBy;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    Collection<ProductWallet> productWalletCollection = new ArrayList<>();

    public Product(Integer id) {
        this.id = id;
    }
}
