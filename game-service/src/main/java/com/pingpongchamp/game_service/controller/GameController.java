package com.pingpongchamp.game_service.controller;


import com.pingpongchamp.common.dtos.GameDto;
import com.pingpongchamp.game_service.mapper.GameMapper;
import com.pingpongchamp.game_service.model.Game;
import com.pingpongchamp.game_service.repository.GameRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

  private final KafkaTemplate<String, String> kafkaTemplate;

  @Resource
  private GameMapper gameMapper;

  @Resource
  private GameRepository gameRepository;

  @PostMapping
  public ResponseEntity<HttpStatus> createGames(List<GameDto> games) {
    List<Game> gameEntities = games.stream().map(game -> gameMapper.toEntity(game)).toList();

    try {
      gameRepository.saveAll(gameEntities);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/tournament-winners")
  public List<Game> getTournamentWinners() {
    return gameRepository.getTournamentWinners();
  }

}
