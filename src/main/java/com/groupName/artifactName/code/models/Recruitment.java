package com.groupName.artifactName.code.models;

import javax.persistence.*;

@Entity
@Table(name = "Recruitment")
public class Recruitment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    Integer id;

    @Column(name = "soldier_id")
    Integer soldier_id;

    @Column(name = "cost")
    Integer cost;

    @Column(name = "don")
    String don;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSoldier_id() {
        return soldier_id;
    }

    public void setSoldier_id(Integer soldier_id) {
        this.soldier_id = soldier_id;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getDon() {
        return don;
    }

    public void setDon(String don) {
        this.don = don;
    }
}
