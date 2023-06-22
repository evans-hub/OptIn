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
 * @author david
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class NetworkSpendLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int clientWalletLimit;
    @JoinColumn(name = "network_type", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private ControlType networkType;

    @JoinColumn(name = "restrict_type", referencedColumnName = "code")
    @ManyToOne(optional = true)
    private RestrictType restrictType;
}

