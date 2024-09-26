package com.pingpongchamp.game_service.proxy;

import com.pingpongchamp.game_service.dto.PlayerDebug;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "player-service")
public interface PlayerProxy {

  @GetMapping("/player/{id}/lb")
  PlayerDebug getPlayerByIdLb(@PathVariable long id);
  
  @GetMapping("/player/exists/{id}")
  boolean playerExistsById(@PathVariable long id);
}
