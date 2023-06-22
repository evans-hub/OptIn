package com.apptivate.OptIn.Entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Country implements Serializable {
    @Id
    private String code;
    private String name;

    public Country(String code) {
        this.code = code;
    }
}
