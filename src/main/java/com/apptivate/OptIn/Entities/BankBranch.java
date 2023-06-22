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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BankBranch {
    @Id
    private Integer id;
    @JoinColumn(name = "bank", referencedColumnName = "id")
    @ManyToOne
    private Bank bank;
    private String code;
    private String name;

    public BankBranch(Integer id) {
        this.id = id;
    }
}
