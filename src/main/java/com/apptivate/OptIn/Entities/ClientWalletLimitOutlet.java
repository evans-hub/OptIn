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
public class ClientWalletLimitOutlet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "outlet", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClientBranch outlet;

    @JoinColumn(name = "client_wallet_limit", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClientWalletCategoryLimit clientWalletCategoryLimit;
}
