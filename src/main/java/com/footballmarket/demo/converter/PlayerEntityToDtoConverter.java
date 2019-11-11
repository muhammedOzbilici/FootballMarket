package com.footballmarket.demo.converter;

import com.footballmarket.demo.dto.PlayerDto;
import com.footballmarket.demo.entity.Player;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PlayerEntityToDtoConverter implements Converter<Player, PlayerDto> {
    @Override
    public PlayerDto convert(Player entity) {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setAge(entity.getAge());
        playerDto.getContract().setContractId(entity.getPlayerId());
        playerDto.setExperienceYear(entity.getExperienceYear());
        playerDto.setName(entity.getName());
        playerDto.getTeam().setTeamId(entity.getPlayerId());

        return playerDto;
    }
}
