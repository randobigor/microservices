package com.pingpongchamp.game_service.repository;

import com.pingpongchamp.game_service.model.Game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

  @Query("SELECT g FROM Game g WHERE g.stage = (SELECT MAX(g2.stage) FROM Game g2 WHERE g2.tournamentId = g.tournamentId)")
  List<Game> getTournamentWinners();

  List<Game> findAllByWinnerId(long winnerId);
  
  List<Game> findAllByTournamentId(long tournamentId);
  
  void deleteAllByTournamentId(long tournamentId);
}
