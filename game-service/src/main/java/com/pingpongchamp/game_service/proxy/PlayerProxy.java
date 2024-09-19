package com.pingpongchamp.game_service.proxy;

import com.pingpongchamp.contracts.Player;
import com.pingpongchamp.contracts.PlayerDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author ibodnar@amsoft-group.com
 */

@FeignClient(name = "player-service")
public interface PlayerProxy {

  @GetMapping("/player")
  List<Player> getAllPlayers();
}
