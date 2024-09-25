package com.pingpongchamp.player_service.proxy;


import com.pingpongchamp.player_service.dto.GameDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author ibodnar@amsoft-group.com
 */

@FeignClient(name = "game-service")
public interface GameProxy {

  @GetMapping("/game/find-all-games-by-winner-id/{winnerId}")
  List<GameDto> getAllGamesByWinnerId(@PathVariable long winnerId);
}
