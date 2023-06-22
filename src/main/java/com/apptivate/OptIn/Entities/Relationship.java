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
import javax.persistence.Table;

/**
 * @author david
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "relationships")
public class Relationship {
    @Id
    private String code;
    private String name;

    public Relationship(String code) {
        this.code = code;
    }


}
