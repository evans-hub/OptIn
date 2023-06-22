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
 * @author hp
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class EmployeeWalletCategoryLimitOutlet {
    @Id
    private Integer id;
    @JoinColumn(name = "employee_wallet_category_limit", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeWalletCategoryLimit employeeWalletCategoryLimit;
    @JoinColumn(name = "outlet", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClientBranch clientBranch;
}

