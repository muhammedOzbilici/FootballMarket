package com.footballmarket.demo.service.impl;

import com.footballmarket.demo.converter.TeamDtoToEntityConverter;
import com.footballmarket.demo.converter.TeamEntityToDtoConverter;
import com.footballmarket.demo.dto.TeamDto;
import com.footballmarket.demo.entity.Team;
import com.footballmarket.demo.exception.TeamNotFoundException;
import com.footballmarket.demo.repository.TeamRepository;
import com.footballmarket.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TeamDtoToEntityConverter dtoToEntityConverter;

    @Autowired
    TeamEntityToDtoConverter entityToDtoConverter;

    @Override
    public void createTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public Optional<Team> findTeamById(Integer id) {
        return teamRepository.findById(id);
    }

    @Override
    public TeamDto updateTeam(Integer id, TeamDto teamDto) {
        Optional<Team> foundTeam = teamRepository.findById(id);
        if (!foundTeam.isPresent()) {
            throw new TeamNotFoundException("team.notFound");
        }
        Team newEntity = dtoToEntityConverter.convert(teamDto);
        newEntity.setTeamId(foundTeam.get().getTeamId());
        return entityToDtoConverter.convert(teamRepository.save(newEntity));
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public void deleteTeam(Integer id) {
        Optional<Team> foundTeam = teamRepository.findById(id);
        if (!foundTeam.isPresent()) {
            throw new TeamNotFoundException("team.notFound");
        }
        teamRepository.delete(foundTeam.get());
    }

    @Override
    public List<Team> findTeamByPlayerName(String playerName) {
        return null;
    }
}
