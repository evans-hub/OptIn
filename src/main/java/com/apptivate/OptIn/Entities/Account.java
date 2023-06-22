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
public class Account {
    @Id
    private Integer id;
    private String role;
    private String roleType;
    private boolean blocked;
    private Date dateBlocked;

    @JsonIgnore
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;

    public Account(Integer id) {
        this.id = id;
    }


}
