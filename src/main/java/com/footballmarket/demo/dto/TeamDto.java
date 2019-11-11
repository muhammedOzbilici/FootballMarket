package com.footballmarket.demo.dto;

public class TeamDto {

    private String name;

    private String curreny;

    @Override
    public String toString() {
        return "TeamDto{" +
                "name='" + name + '\'' +
                ", curreny='" + curreny + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurreny() {
        return curreny;
    }

    public void setCurreny(String curreny) {
        this.curreny = curreny;
    }
}
