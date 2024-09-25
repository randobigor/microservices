package com.pingpongchamp.tournament_service.proxy;


import com.pingpongchamp.common.dto.GameDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "game-service")
public interface GameProxy {

  @PostMapping("/")
  ResponseEntity<HttpStatus> createGames(List<GameDto> games);

  @GetMapping("/game/tournament-winners")
  public List<GameDto> getTournamentWinners();
}
