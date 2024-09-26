package com.pingpongchamp.game_service.service;

import com.pingpongchamp.game_service.model.Game;
import com.pingpongchamp.game_service.proxy.PlayerProxy;
import com.pingpongchamp.game_service.repository.GameRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;

/**
 * @author ibodnar@amsoft-group.com
 */

@Service
public class GameService {

  @Resource
  private GameRepository gameRepository;

  @Resource
  private PlayerProxy playerProxy;

  @Transactional
  public ResponseEntity<HttpStatus> createGames(List<Game> games) {
    long tournamentId = games.get(0).getTournamentId();

    for (Game game : games) {
      if (areAllPlayersPresent(game)) {
        try {
          gameRepository.save(game);
        } catch (Exception e) {
          compensateGames(tournamentId);
          return ResponseEntity.badRequest().build();
        }
      } else {
        compensateGames(tournamentId);
        return ResponseEntity.notFound().build();
      }
    }

    return ResponseEntity.ok().build();
  }

  private void compensateGames(long tournamentId) {
    gameRepository.deleteAllByTournamentId(tournamentId);
  }

  private boolean areAllPlayersPresent(Game game) {
    boolean firstPlayerExists = playerProxy.playerExistsById(game.getFirstPlayerId());
    boolean secondPlayerExists = playerProxy.playerExistsById(game.getSecondPlayerId());

    return firstPlayerExists && secondPlayerExists;
  }
}
