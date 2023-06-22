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

/**
 * @author david
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "limits")
public class Limit {
    @Id
    private String code;
    private String name;

    @JoinColumn(name = "limit_value_type", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private LimitValueType limitValueType;

    public Limit(String code) {
        this.code = code;
    }

}
