/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apptivate.OptIn.Utils;


/**
 * @author david
 */
public enum Response {
    SUCCESS(0, "Success"),
    INVALID_RESPONSE(1, "Invalid Response"),
    ERROR_INVALID_ACCESS(2, "Invalid access");

    private final Status status;

    Response(int code, String message) {
        this.status = new Status(code, message);

    }

    public Status status() {
        return status;

    }
}
