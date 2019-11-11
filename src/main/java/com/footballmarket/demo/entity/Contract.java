package com.footballmarket.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CONTRACT")
public class Contract {

    @Id
    @Column(name = "CONTRACT_ID")
    private Integer contractId;


    @Column(name = "PLAYER_ID")
    private Integer playerId;

    @Column(name = "TEAM_NAME")
    private String teamName;

    @Column(name = "TRANSFER_DATE")
    private Date tranferDate;

    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Column(name = "TRANSFER_COST")
    private Double transferCost;

    @Column(name = "CONTRACT_COST")
    private Double contractCost;

    @Column(name = "TEAM_COMISSION")
    private Double teamComission;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    public Contract() {
    }

    public Contract(Integer contractId, Integer playerId, String teamName, Date tranferDate, Date releaseDate, Double transferCost, Double contractCost, Double teamComission, boolean isActive) {
        this.contractId = contractId;
        this.playerId = playerId;
        this.teamName = teamName;
        this.tranferDate = tranferDate;
        this.releaseDate = releaseDate;
        this.transferCost = transferCost;
        this.contractCost = contractCost;
        this.teamComission = teamComission;
        this.isActive = isActive;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
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
}
