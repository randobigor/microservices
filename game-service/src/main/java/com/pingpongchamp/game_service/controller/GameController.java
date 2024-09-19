package com.pingpongchamp.game_service.controller;


import com.pingpongchamp.contracts.Player;
import com.pingpongchamp.contracts.PlayerDto;
import com.pingpongchamp.game_service.proxy.PlayerProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ibodnar@amsoft-group.com
 */

@RestController
@RequestMapping("/game")
public class GameController {

  @Autowired
  private PlayerProxy playerProxy;

  @GetMapping
  public List<Player> test() {
    return playerProxy.getAllPlayers();
  }
}
