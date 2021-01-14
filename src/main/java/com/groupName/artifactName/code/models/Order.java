package com.groupName.artifactName.code.models;

import javax.persistence.*;

@Entity
@Table(name = "\"Order\"")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    Integer id;

    @Column(name = "don")
    Integer don;

    @Column(name = "cost")
    Integer cost;

    @Column(name = "income")
    Integer income;

    @Column(name = "soldiers_number")
    Integer soldiers_number;

    @Column(name = "lawyers_number")
    Integer lawyers_number;

    @Column(name = "sphere_of_influence")
    String sphere_of_influence;

    @Column(name = "description")
    String description;

    @Transient
    String family;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDon() {
        return don;
    }

    public void setDon(Integer don) {
        this.don = don;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public Integer getSoldiers_number() {
        return soldiers_number;
    }

    public void setSoldiers_number(Integer soldiers_number) {
        this.soldiers_number = soldiers_number;
    }

    public Integer getLawyers_number() {
        return lawyers_number;
    }

    public void setLawyers_number(Integer lawyers_number) {
        this.lawyers_number = lawyers_number;
    }

    public String getSphere_of_influence() {
        return sphere_of_influence;
    }

    public void setSphere_of_influence(String sphere_of_influence) {
        this.sphere_of_influence = sphere_of_influence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
