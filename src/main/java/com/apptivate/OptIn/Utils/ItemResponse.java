/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apptivate.OptIn.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hp
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse<T> {
    private Status status;
    private T data;
}
