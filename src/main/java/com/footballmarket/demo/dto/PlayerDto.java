package com.footballmarket.demo.dto;

import com.footballmarket.demo.entity.Contract;
import com.footballmarket.demo.entity.Team;

public class PlayerDto {


    private String name;


    private Team team;


    private Contract contract;


    private short age;


    private double salary;


    private short experienceYear;

    public PlayerDto(String name, Team team, Contract contract, short age, double salary, short experienceYear) {
        this.name = name;
        this.team = team;
        this.contract = contract;
        this.age = age;
        this.salary = salary;
        this.experienceYear = experienceYear;
    }

    public PlayerDto() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public short getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(short experienceYear) {
        this.experienceYear = experienceYear;
    }
}
