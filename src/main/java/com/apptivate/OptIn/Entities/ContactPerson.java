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
import java.util.Date;

/**
 * @author david
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ContactPerson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    @JoinColumn(name = "designation", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Designation designation;
    @JoinColumn(name = "client_branch", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private ClientBranch clientBranch;
    @JoinColumn(name = "client", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Client client;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateLastUpdated;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateDeleted;
    private int createdBy;

    public ContactPerson(Integer id) {
        this.id = id;
    }


}
