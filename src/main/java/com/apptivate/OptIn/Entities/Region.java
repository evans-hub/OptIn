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

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "country", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Country country;
    private String name;

    @JsonIgnore
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreated;
    @JsonIgnore
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateLastUpdated;
    @JsonIgnore
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateDeleted;
    @JsonIgnore
    private int createdBy;

    public Region(Integer id) {
        this.id = id;
    }


}
