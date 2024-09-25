package com.pingpongchamp.game_service.mapper;


import com.pingpongchamp.game_service.dto.GameDto;
import com.pingpongchamp.game_service.model.Game;

import org.springframework.stereotype.Component;

/**
 * @author ibodnar@amsoft-group.com
 */

//hardcoded
@Component
public class GameMapper {

  public Game toEntity(GameDto dto) {
    Game game = new Game();

    game.setTournamentId(dto.getTournamentId());
    game.setFirstPlayerId(dto.getFirstPlayerId());
    game.setSecondPlayerId(dto.getSecondPlayerId());

    return game;
  }
}
