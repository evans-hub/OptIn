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
import java.io.Serializable;

/**
 * @author hp
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class App implements Serializable {
    @Id
    private String code;
    private String secret;
    private String name;
    private String roleType;
    private String channel;
    private String gatewayAppKey;
    private String gatewayAppSecret;
    private String token;
}
