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
import java.io.Serializable;

/**
 * @author david
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ClientWalletLimitDay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @JoinColumn(name = "client_wallet_limit", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClientWalletCategoryLimit clientWalletCategoryLimit;
    @JoinColumn(name = "day", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Day day;
    private String startTime;
    private String endTime;

    public ClientWalletLimitDay(Integer id) {
        this.id = id;
    }


}
