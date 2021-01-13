package com.example.springboot.persistence;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private long id;
    private String value;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @Column
    public String getValue() {
        return value;
    }
}
