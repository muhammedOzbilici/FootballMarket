package com.footballmarket.demo.converter;

import com.footballmarket.demo.dto.PlayerDto;
import com.footballmarket.demo.entity.Player;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PlayerDtoToEntityConverter implements Converter<PlayerDto, Player> {
    @Override
    public Player convert(PlayerDto playerDto) {

        Player entity = new Player();
        entity.setAge(playerDto.getAge());
        entity.setExperienceYear(playerDto.getExperienceYear());
        entity.setName(playerDto.getName());
        entity.setSalary(playerDto.getSalary());
        return entity;
    }
}
