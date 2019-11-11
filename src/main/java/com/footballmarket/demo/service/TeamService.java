package com.footballmarket.demo.service;

import com.footballmarket.demo.dto.TeamDto;
import com.footballmarket.demo.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    void createTeam(Team team);

    Optional<Team> findTeamById(Integer id);

    TeamDto updateTeam(Integer id, TeamDto teamDto);

    List<Team> findAll();

    void deleteTeam(Integer id);

    List<Team> findTeamByPlayerName(String playerName);
}
