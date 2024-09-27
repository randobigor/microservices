package com.pingpongchamp.player_service.controller;

import com.pingpongchamp.player_service.dto.DefeatedPlayerDto;
import com.pingpongchamp.player_service.dto.PlayerDebug;
import com.pingpongchamp.player_service.model.Player;
import com.pingpongchamp.player_service.repository.PlayerRepository;
import com.pingpongchamp.player_service.service.PlayerService;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ibodnar@amsoft-group.com
 */

@RestController
@RequestMapping("/player")
@Slf4j
public class PlayerController {

  @Resource
  private PlayerRepository playerRepository;

  @Resource
  private PlayerService playerService;

  @Resource
  private Environment environment;

  @GetMapping
  public List<Player> getAllPlayers() {
    return playerRepository.findAll();
  }

  @GetMapping("/{id}")
  public Player getPlayerById(@PathVariable long id) {
    return playerRepository.findById(id).orElse(null);
  }

  @GetMapping("/exists/{id}")
  public boolean playerExistsById(@PathVariable long id) {
    return playerRepository.existsById(id);
  }

  @GetMapping("/{id}/lb")
  public PlayerDebug getPlayerByIdLb(@PathVariable long id) throws Exception {
    Player player = playerRepository.findById(id).orElse(null);

    return PlayerDebug.builder()
        .player(player)
        .environment(buildLogInfo())
        .build();
  }

  @GetMapping("/order-by-score")
  public List<Player> retrieveAllPlayersOrderedByPoints() {
    return playerRepository.findAllByOrderByScoreDesc();
  }

  @GetMapping("/defeated-players/{playerName}")
  public ResponseEntity<List<DefeatedPlayerDto>> defeatedPlayers(@PathVariable String playerName) {
    return ResponseEntity.ok(playerService.getDefeatedPlayers(playerName));
  }

  @PostMapping
  public void addPlayer(@RequestBody Player player) {
    playerRepository.save(player);
  }

  private String buildLogInfo() throws Exception {
    String envAddr = environment.getProperty("local.server.address");
    String envPort = environment.getProperty("local.server.port");

    String localIp = InetAddress.getLocalHost().getHostAddress();
    String localHn = InetAddress.getLocalHost().getHostName();

    String remoteAddress = InetAddress.getLoopbackAddress().getHostAddress();
    String remoteHostname = InetAddress.getLoopbackAddress().getHostName();

    String response = String.format("Environment address: %s\nEnvironment port: %s\nLocal address: %s\nLocal hostname: %s\n Remote address: %s\nRemote hostname: %s",
                                    envAddr, envPort, localIp, localHn, remoteAddress, remoteHostname);

    return response;
  }
}

