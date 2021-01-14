package com.groupName.artifactName.code.models;

import javax.persistence.*;

@Entity
@Table(name = "Soldier")
public class Soldier {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "age")
    Integer age;
    @Column(name = "is_busy")
    boolean is_busy;
    @Column(name = "family")
    String family;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isIs_busy() {
        return is_busy;
    }

    public void setIs_busy(boolean is_busy) {
        this.is_busy = is_busy;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
