package com.footballmarket.demo.converter;

import com.footballmarket.demo.dto.TeamDto;
import com.footballmarket.demo.entity.Team;
import org.springframework.core.convert.converter.Converter;

public class TeamEntityToDtoConverter implements Converter<Team, TeamDto> {
    @Override
    public TeamDto convert(Team team) {
        TeamDto teamDto = new TeamDto();
        teamDto.setCurreny(team.getCurrency());
        teamDto.setName(team.getName());

        return teamDto;
    }
}
