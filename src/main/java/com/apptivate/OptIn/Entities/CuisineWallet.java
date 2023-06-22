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

/**
 * @author hp
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CuisineWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "wallet", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Wallet wallet;
    @JoinColumn(name = "cuisine", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cuisine cuisine;


    public CuisineWallet(Integer id) {
        this.id = id;
    }
}
