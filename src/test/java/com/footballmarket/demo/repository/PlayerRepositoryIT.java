package com.footballmarket.demo.repository;

import com.footballmarket.demo.entity.Player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlayerRepositoryIT {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PlayerRepository playerRepository;

    @Test
    public void it_should_save_player_successfully() throws Exception {
        //arrange
        Player savedPlayer = new Player(1, 1, "john", 20, 100.0, 3);
        jdbcTemplate.execute("insert into PLAYER (TEAM_ID,CONTRACT_ID,NAME,AGE,SALARY,EXPERIENCE_YEAR)\n" +
                " values (1,1,'john',20,1000000,3)");


        //act
        Optional<Player> expectedPlayer = playerRepository.findById(1);

        //assert
        Optional<Player> player = expectedPlayer;
        Assert.assertEquals(player, expectedPlayer);

    }
}
