/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apptivate.OptIn.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
public class EmployeeWalletCategory {

    @Id
    private Integer id;
    @JoinColumn(name = "employee_client", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeClient employeeClient;
    @JoinColumn(name = "client_wallet_category", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClientWalletCategory clientWalletCategory;
    @OneToMany(mappedBy = "employeeWalletCategory")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<EmployeeWalletCategoryLimit> employeeWalletCategoryLimitCollection;
    private Date dateCreated;
    private Date dateDeleted;

    public EmployeeWalletCategory(Integer id) {
        this.id = id;
    }


}
