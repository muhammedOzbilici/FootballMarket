package com.footballmarket.demo.converter;

import com.footballmarket.demo.dto.TeamDto;
import com.footballmarket.demo.entity.Team;
import org.springframework.core.convert.converter.Converter;

public class TeamDtoToEntityConverter implements Converter<TeamDto, Team> {
    @Override
    public Team convert(TeamDto teamDto) {
        Team team = new Team();
        team.setName(teamDto.getName());
        team.setCurrency(teamDto.getCurreny());

        return team;
    }
}
