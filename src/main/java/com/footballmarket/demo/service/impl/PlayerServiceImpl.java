package com.footballmarket.demo.service.impl;

import com.footballmarket.demo.converter.PlayerDtoToEntityConverter;
import com.footballmarket.demo.converter.PlayerEntityToDtoConverter;
import com.footballmarket.demo.dto.PlayerDto;
import com.footballmarket.demo.entity.Player;
import com.footballmarket.demo.exception.PlayerNotFoundException;
import com.footballmarket.demo.repository.PlayerRepository;
import com.footballmarket.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerDtoToEntityConverter dtoToEntityConverter;

    @Autowired
    PlayerEntityToDtoConverter entityToDtoConverter;

    @Override
    public void createPlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Optional<Player> findPlayerById(Integer id) {
        return playerRepository.findById(id);
    }

    @Override
    public PlayerDto updatePlayer(Integer id, PlayerDto playerDto) {
        Optional<Player> foundPlayer = playerRepository.findById(id);
        if (!foundPlayer.isPresent()) {
            throw new PlayerNotFoundException("player.notFound");
        }
        Player newEntity = dtoToEntityConverter.convert(playerDto);
        newEntity.setPlayerId(foundPlayer.get().getPlayerId());
        return entityToDtoConverter.convert(playerRepository.save(newEntity));

    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public void deletePlayer(Integer id) {
        Optional<Player> foundPlayer = playerRepository.findById(id);
        if (!foundPlayer.isPresent()) {
            throw new PlayerNotFoundException("player.notFound");
        }
        playerRepository.delete(foundPlayer.get());
    }

    @Override
    public List<Player> findPlayerByTeamIdAndContractYear(String teamName, Date contractYear) {
        return null;
    }


}
