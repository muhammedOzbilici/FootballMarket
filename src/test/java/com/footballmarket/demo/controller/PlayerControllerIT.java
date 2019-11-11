package com.footballmarket.demo.controller;

import com.footballmarket.demo.base.BaseIT;
import com.footballmarket.demo.entity.Player;
import com.footballmarket.demo.service.PlayerService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@WebMvcTest(MainController.class)
public class PlayerControllerIT extends BaseIT {

    @MockBean
    private PlayerService playerService;

    @Captor
    private ArgumentCaptor<Player> playerArgumentCaptor;

    @Test
    public void it_should_save_player() throws Exception {
        //given
        Player player = new Player(1, 1, "john", 20, 100.0, 3);

        //when
        ResultActions expectedResult = mockMvc.perform(post("/save?id=1&" +
                "name=john&age=20&salary=100&experienceYear=3")
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print());

        //then
        verify(playerService).createPlayer(playerArgumentCaptor.capture());
        Player expectedPlayer=playerArgumentCaptor.getValue();
        assertThat(expectedPlayer).isEqualToComparingFieldByField(player);
        expectedResult.andExpect(status().is3xxRedirection());

    }

    @Test
    public void it_should_find_player_by_id() throws Exception{

        //given
        Player player = new Player(1, 1, "john", 20, 100.0, 3);
        given(playerService.findPlayerById(1)).willReturn(Optional.of(player));

        //when
        ResultActions expectedResult =mockMvc.perform(get("/find/?id=1&")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print());


        //then
        expectedResult.andExpect(status().is2xxSuccessful());
        expectedResult.andExpect(jsonPath("$.id").value(1));
        expectedResult.andExpect(jsonPath("$.name").value("john"));
        expectedResult.andExpect(jsonPath("$.experienceYear").value(3));
        expectedResult.andExpect(jsonPath("$.age").value(20));
    }

    @Test
    public void it_should_delete_player_by_id() throws Exception{
        //given
        Player player = new Player(1, 1, "john", 20, 100.0, 3);
        given(playerService.findPlayerById(1)).willReturn(Optional.of(player));

        //when
        ResultActions expectedResult =mockMvc.perform(get("/delete?id=1&")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print());

        //then
        verify(playerService).deletePlayer(player.getPlayerId());
        expectedResult.andExpect(status().is3xxRedirection());
    }

    @Test
    public void it_should_update_player_by_id() throws Exception {

        //given
        Player savedPlayer = new Player(1, 1, "john", 20, 100.0, 3);
        playerService.createPlayer(savedPlayer);
        given(playerService.findPlayerById(savedPlayer.getPlayerId())).willReturn(Optional.of(savedPlayer));

        //when
        ResultActions expectedResult = mockMvc.perform(post("/edit?id=1&" +
                "name=john&age=21")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print());


        //then

        verify(playerService).updatePlayer(playerArgumentCaptor.capture());
        Player expectedPlayer = playerArgumentCaptor.getValue();
        assertThat(expectedPlayer.getAge()).isEqualTo(20);
        expectedResult.andExpect(status().is3xxRedirection());

    }


}
