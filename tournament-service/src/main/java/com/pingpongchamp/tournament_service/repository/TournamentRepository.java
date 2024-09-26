package com.pingpongchamp.tournament_service.repository;

import com.pingpongchamp.tournament_service.model.Tournament;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
  
  Tournament findByDate(LocalDate date);
}
