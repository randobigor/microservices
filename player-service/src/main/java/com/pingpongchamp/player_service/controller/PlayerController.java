package com.pingpongchamp.player_service.controller;

import com.pingpongchamp.player_service.model.Player;
import com.pingpongchamp.player_service.repository.PlayerRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.annotation.Resource;

/**
 * @author ibodnar@amsoft-group.com
 */

@RestController
@RequestMapping("/player")
public class PlayerController {

  @Resource
  private PlayerRepository playerRepository;

  @GetMapping
  public List<Player> getAllPlayers() {
    return playerRepository.findAll();
  }

  @GetMapping("/{id}")
  public Player getPlayerById(@PathVariable long id) {
    return playerRepository.findById(id).orElse(null);
  }

  @GetMapping("/order-by-score")
  public List<Player> retrieveAllPlayersOrderedByPoints() {
    return playerRepository.findAllByOrderByScoreDesc();
  }


  @PostMapping
  public void addPlayer(@RequestBody Player player) {
    playerRepository.save(player);
  }
}
