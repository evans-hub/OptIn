/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apptivate.OptIn.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;
import java.util.Date;

/**
 * @author hp
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class EmployeeClient {

    @Id
    private Integer id;

    @JoinColumn(name = "client", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client client;
    @JsonIgnore
    @XmlTransient
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "client_branch", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClientBranch clientBranch;

    @JoinColumn(name = "status", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private UserStatus status;
    private String qrCode;
    private String pfNumber;
    private Integer jpCorrelator;
    private Date dateCreated;
    private Date dateDeleted;

    @OneToMany(mappedBy = "employeeClient")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<EmployeeWalletCategory> employeeWalletCategoryCollection;

    public EmployeeClient(Integer id) {
        this.id = id;
    }

}
