package com.footballmarket.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "TEAM")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    private Integer teamId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CURRENCY")
    private String currency;

    public Team() {
    }

    public Team(Integer teamId, String name, String currency) {
        this.teamId = teamId;
        this.name = name;
        this.currency = currency;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
