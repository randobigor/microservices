package com.pingpongchamp.game_service.controller;


import com.pingpongchamp.game_service.dto.PlayerDebug;
import com.pingpongchamp.game_service.mapper.GameMapper;
import com.pingpongchamp.game_service.model.Game;
import com.pingpongchamp.game_service.proxy.PlayerProxy;
import com.pingpongchamp.game_service.repository.GameRepository;
import com.pingpongchamp.game_service.service.GameService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;

/**
 * @author ibodnar@amsoft-group.com
 */

@AllArgsConstructor
@RestController
@RequestMapping("/game")
public class GameController {

  @Resource
  private GameMapper gameMapper;

  @Resource
  private GameRepository gameRepository;

  @Resource
  private PlayerProxy playerProxy;

  @Resource
  private GameService gameService;

  @PostMapping
  public ResponseEntity<HttpStatus> createGames(@RequestBody List<Game> games) {
    return gameService.createGames(games);
  }

  @GetMapping("/by-tournament-id")
  public List<Game> getAllGamesByTournamentId(@RequestParam long tournamentId) {
    return gameRepository.findAllByTournamentId(tournamentId);
  }
  
  //For testing purposes only
  @GetMapping("/get-player-by-id/{id}")
  public PlayerDebug getPlayerById(@PathVariable long id) {
    return playerProxy.getPlayerByIdLb(id);
  }

  @GetMapping("/tournament-winners")
  public List<Game> getTournamentWinners() {
    return gameRepository.getTournamentWinners();
  }

  @GetMapping("/find-all-games-by-winner-id/{winnerId}")
  public List<Game> getAllGamesByWinnerId(@PathVariable long winnerId) {
    return gameRepository.findAllByWinnerId(winnerId);
  }

}
