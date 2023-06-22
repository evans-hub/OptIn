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
@Table(name = "orders")
public class Order {
    @Id
    private Integer id;
    private String name;
    private String status;
    private String orderType;
    @JoinColumn(name = "client_branch", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private ClientBranch clientBranch;
    @JsonIgnore
    @JoinColumn(name = "client", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Client client;
    private double amount;
    private double invoiceAmount;
    private String wallet;
    private String currency;
    private Date dateCreated;
    private Date dateDeleted;
    private Date dateAuthorized;
    private Date dateInvoiced;
    private Date dateDisbursed;


}
