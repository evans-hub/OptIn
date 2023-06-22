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
 * @author hp
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastUpdated;
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;
    @JsonIgnore
    private int createdBy;

    @OneToMany(mappedBy = "cuisine")
    private Collection<CuisineWallet> cuisineWallets;

    public Cuisine(Integer id) {
        this.id = id;
    }


}
