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

/**
 *
 * @author david
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ClientProduct {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
     @JoinColumn(name = "client", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client client;
     @JoinColumn(name = "product", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product product;
     private String rate;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreated;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateLastUpdated;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateDeleted;
   
    private int createdBy;

    public ClientProduct(Integer id) {
        this.id = id;
    }
    
    
}
