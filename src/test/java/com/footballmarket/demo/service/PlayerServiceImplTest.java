package com.footballmarket.demo.service;

import com.footballmarket.demo.base.BaseMockitoTest;
import com.footballmarket.demo.entity.Player;
import com.footballmarket.demo.repository.PlayerRepository;
import com.footballmarket.demo.service.impl.PlayerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

public class PlayerServiceImplTest extends BaseMockitoTest {

    @InjectMocks
    private PlayerServiceImpl playerService;

    @Mock
    private PlayerRepository playerRepository;

    public Player entity;

    @Before
    public void before() {
        entity = new Player();
        entity.setSalary(100.0);
        entity.getAge(20);
        entity.setExperienceYear(3);
        entity.setName("john");
    }

    @Test
    public void it_should_save_player() {
        //given
        Player player = new Player(1, 1, "john", 20, 100.0, 3);

        //when
        playerService.createPlayer(player);

        //then
        verify(playerRepository).save(player);
    }


}
