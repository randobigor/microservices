package com.pingpongchamp.player_service.repository;

import com.pingpongchamp.player_service.model.Player;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author ibodnar@amsoft-group.com
 */

public interface PlayerRepository extends JpaRepository<Player, Long> {

  List<Player> findAllByOrderByScoreDesc();

  Optional<Player> findByName(String name);
}
