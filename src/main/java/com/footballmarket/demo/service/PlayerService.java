package com.footballmarket.demo.service;

import com.footballmarket.demo.dto.PlayerDto;
import com.footballmarket.demo.entity.Player;
import com.footballmarket.demo.entity.Team;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PlayerService {

    void createPlayer(Player player);

    Optional<Player> findPlayerById(Integer id);

    PlayerDto updatePlayer(Integer id, PlayerDto playerDto);

    List<Player> findAll();

    void deletePlayer(Integer id);

    List<Player> findPlayerByTeamIdAndContractYear(String teamName, Date contractYear);


}
