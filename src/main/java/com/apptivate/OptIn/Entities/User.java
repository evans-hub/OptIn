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
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author hp
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {
    @Id
    private Integer id;
    private String code;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String fcmToken;
    private String staffNo;
    @JoinColumn(name = "client_branch", referencedColumnName = "id")
    @ManyToOne
    private ClientBranch clientBranch;
    @JoinColumn(name = "client", referencedColumnName = "id")
    @ManyToOne
    private Client client;
    private String correlator;
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;

    @OneToMany(mappedBy = "user")
    @LazyCollection(LazyCollectionOption.FALSE) 
    private Collection<Account> accountsCollection;

    public User(Integer id) {
        this.id = id;
    }

    public String getName() {
        return String.format("%s %s", firstName, lastName);
    }
}
