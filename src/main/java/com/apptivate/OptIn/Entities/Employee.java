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

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Employee {
    @Id
    private Integer id;
    private String code;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String countryCode;
    private String fcmToken;
    private String correlator;
    private Date dateCreated;
    private Date dateDeleted;
    private String staffNo;


    @OneToMany(mappedBy = "employee")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<EmployeeClient> employeeClientCollection;


    public Employee(Integer id) {
        this.id = id;
    }

    public String getName() {
        return String.format("%s %s", firstName, lastName);
    }

    @JsonIgnore
    @XmlTransient
    public Collection<EmployeeClient> getEmployeeClientCollection() {
        return employeeClientCollection;
    }
}
