package com.footballmarket.demo.controller;

import com.footballmarket.demo.entity.Player;
import com.footballmarket.demo.entity.Team;
import com.footballmarket.demo.repository.PlayerRepository;
import com.footballmarket.demo.repository.TeamRepository;
import com.footballmarket.demo.service.PlayerService;
import com.footballmarket.demo.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerService playerService;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TeamService teamService;

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @PostMapping("/save/player")
    public ResponseEntity<?> savePlayer(@RequestBody Player request) {
        logger.info("One player created.");
        return new ResponseEntity<>(playerRepository.save(request), HttpStatus.CREATED);
    }

    @PostMapping("/save/team")
    public ResponseEntity<?> saveTeam(@RequestBody Team request) {
        logger.info("One team created.");
        return new ResponseEntity<>(teamRepository.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/update/player/{id}")
    public ResponseEntity<?> updatePlayerById(@RequestBody Player request, BindResult result) {
        Player updatedPlayer = playerRepository.saveAndFlush(request);
        return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
    }

    @PutMapping("/update/team/{id}")
    public ResponseEntity<?> updateTeamById(@RequestBody Team request, BindResult result) {
        Team updatedTeam = teamRepository.saveAndFlush(request);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }

    @DeleteMapping("/delete/player/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayerById(@PathVariable Integer id) {
        playerService.deletePlayer(id);
    }

    @DeleteMapping("/delete/team/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeamById(@PathVariable Integer id) {
        teamService.deleteTeam(id);
    }

    @GetMapping("/players")
    public ResponseEntity<?> findAllPlayers() {
        return new ResponseEntity<>(playerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/teams")
    public ResponseEntity<?> findAllTeams() {
        return new ResponseEntity<>(teamRepository.findAll(), HttpStatus.OK);
    }




}
