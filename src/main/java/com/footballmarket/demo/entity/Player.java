package com.footballmarket.demo.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PLAYER")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAYER_ID")
    private Integer playerId;

    @OneToMany(fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(name = "TEAM",joinColumns = {
        @JoinColumn(name = "TEAM_ID",referencedColumnName = "PLAYER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PLAYER_ID",referencedColumnName = "TEAM_ID")}
    )
    private Set<Team> teamId;

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(name = "CONTRACT",joinColumns = {
            @JoinColumn(name = "CONTRACT_ID",referencedColumnName = "PLAYER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PLAYER_ID",referencedColumnName = "CONTRACT_ID")}
    )
    private Set<Contract> contractId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private short age;

    @Column(name = "SALARY")
    private Double salary;

    @Column(name = "EXPERIENCE_YEAR")
    private short experienceYear;

    public Player() {
    }

    public Player(Set<Team> teamId, Set<Contract> contractId, String name, short age, Double salary, short experienceYear) {
        this.teamId = teamId;
        this.contractId = contractId;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.experienceYear = experienceYear;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Set<Team> getTeamId() {
        return teamId;
    }

    public void setTeamId(Set<Team> teamId) {
        this.teamId = teamId;
    }

    public Set<Contract> getContractId() {
        return contractId;
    }

    public void setContractId(Set<Contract> contractId) {
        this.contractId = contractId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public short getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(short experienceYear) {
        this.experienceYear = experienceYear;
    }
}
