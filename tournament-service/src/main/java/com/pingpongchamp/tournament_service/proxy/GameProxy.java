package com.pingpongchamp.tournament_service.proxy;


import com.pingpongchamp.tournament_service.dto.GameDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "game-service")
public interface GameProxy {

  @PostMapping("/game")
  ResponseEntity<HttpStatus> createGames(@RequestBody List<GameDto> games);

  @GetMapping("/game/tournament-winners")
  public List<GameDto> getTournamentWinners();

  @GetMapping("/game/by-tournament-id")
  public List<GameDto> getAllGamesByTournamentId(@RequestParam long tournamentId);
}
