package com.pingpongchamp.player_service.repository;

import com.pingpongchamp.player_service.model.Player;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ibodnar@amsoft-group.com
 */

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
