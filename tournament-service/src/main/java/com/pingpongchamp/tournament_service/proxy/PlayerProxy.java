package com.pingpongchamp.tournament_service.proxy;



import com.pingpongchamp.tournament_service.dto.PlayerDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "player-service")
public interface PlayerProxy {

  @GetMapping("/")
  List<PlayerDto> getAllPlayers();

  @GetMapping("/player/{id}")
  PlayerDto getPlayerById(@PathVariable long id);
}
