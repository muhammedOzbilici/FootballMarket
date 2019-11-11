package com.footballmarket.demo.dto;

import java.util.Date;

public class ContractDto {


    private String playerName;


    private String teamName;


    private Date tranferDate;


    private Date releaseDate;


    private Double transferCost;


    private Double contractCost;


    private Double teamComission;


    private boolean isActive;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getTranferDate() {
        return tranferDate;
    }

    public void setTranferDate(Date tranferDate) {
        this.tranferDate = tranferDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getTransferCost() {
        return transferCost;
    }

    public void setTransferCost(Double transferCost) {
        this.transferCost = transferCost;
    }

    public Double getContractCost() {
        return contractCost;
    }

    public void setContractCost(Double contractCost) {
        this.contractCost = contractCost;
    }

    public Double getTeamComission() {
        return teamComission;
    }

    public void setTeamComission(Double teamComission) {
        this.teamComission = teamComission;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "ContractDto{" +
                "playerName='" + playerName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", tranferDate=" + tranferDate +
                ", releaseDate=" + releaseDate +
                ", transferCost=" + transferCost +
                ", contractCost=" + contractCost +
                ", teamComission=" + teamComission +
                ", isActive=" + isActive +
                '}';
    }
}
