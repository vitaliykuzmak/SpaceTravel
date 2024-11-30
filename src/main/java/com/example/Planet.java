package com.example;

import jakarta.validation.constraints.Pattern;

import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @Pattern(regexp = "^[A-Z0-9]+$", message = "ID must contain only uppercase Latin letters and digits")
    @Column(length = 10)
    private String id;

    @Column(nullable = false, length = 500)
    private String name;

    // Конструктори
    public Planet() {}

    public Planet(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // гетери сетери
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

