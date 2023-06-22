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
import java.util.Date;

/**
 * @author hp
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class EmployeeWalletCategoryLimit {

    @Id
    private Integer id;
    @JoinColumn(name = "employee_wallet_category", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeWalletCategory employeeWalletCategory;
    @JoinColumn(name = "client_wallet_limit", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClientWalletCategoryLimit clientWalletCategoryLimit;
    private String value;
    private Date dateCreated;
    private Date dateDeleted;

    public EmployeeWalletCategoryLimit(Integer id) {
        this.id = id;
    }


}
