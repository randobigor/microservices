package com.pingpongchamp.player_service.service;

import com.pingpongchamp.player_service.dto.DefeatedPlayerDto;
import com.pingpongchamp.player_service.dto.GameDto;
import com.pingpongchamp.player_service.model.Player;
import com.pingpongchamp.player_service.proxy.GameProxy;
import com.pingpongchamp.player_service.repository.PlayerRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.annotation.Resource;

/**
 * @author ibodnar@amsoft-group.com
 */

@Service
public class PlayerService {

  @Resource
  private PlayerRepository playerRepository;

  @Resource
  private GameProxy gameProxy;

  public List<DefeatedPlayerDto> getDefeatedPlayers(String playerName) {
    Optional<Player> player = playerRepository.findByName(playerName);

    if (player.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Unable to find player with name: %S", playerName));
    }

    List<GameDto> winnings = gameProxy.getAllGamesByWinnerId(player.get().getId());
    List<DefeatedPlayerDto> defeatedPlayers = new ArrayList<>();

    for (GameDto game : winnings) {
      DefeatedPlayerDto defeatedPlayer = new DefeatedPlayerDto();

      defeatedPlayer.setGameStartTime(game.getStartDateTime());
      defeatedPlayer.setDuration(game.getDuration());
      defeatedPlayer.setFinalScore(game.getFinalScore());
  
      Player opponent = playerRepository.findById(getOpponentId(player.get().getId(), game)).orElse(null);
      assert opponent != null;
      defeatedPlayer.setOpponentName(opponent.getName());

      defeatedPlayers.add(defeatedPlayer);
    }

    return defeatedPlayers;
  }

  private long getOpponentId(Long playerId, GameDto game) {
    return playerId.equals(game.getFirstPlayerId()) ? game.getSecondPlayerId() : game.getFirstPlayerId();
  }
}
