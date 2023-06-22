/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apptivate.OptIn.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author david
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Wallet {
    @Id
    private String code;
    private String name;
    private String sev;
    @JoinColumn(name = "country", referencedColumnName = "code")
    @ManyToOne
    private Country country;
    public Wallet(String code) {
        this.code = code;
    }
}
