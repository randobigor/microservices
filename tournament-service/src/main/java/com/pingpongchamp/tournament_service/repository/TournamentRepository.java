package com.pingpongchamp.tournament_service.repository;

import com.pingpongchamp.tournament_service.model.Tournament;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
