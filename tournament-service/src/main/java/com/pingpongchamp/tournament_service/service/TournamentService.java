package com.pingpongchamp.tournament_service.service;

import com.pingpongchamp.common.dto.GameDto;
import com.pingpongchamp.common.dto.PlayerDto;
import com.pingpongchamp.tournament_service.dto.TournamentAndWinnerDto;
import com.pingpongchamp.tournament_service.dto.TournamentWinnerDto;
import com.pingpongchamp.tournament_service.model.Tournament;
import com.pingpongchamp.tournament_service.proxy.GameProxy;
import com.pingpongchamp.tournament_service.proxy.PlayerProxy;
import com.pingpongchamp.tournament_service.repository.TournamentRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;

/**
 * @author ibodnar@amsoft-group.com
 */

@Service
public class TournamentService {

  @Resource
  private TournamentRepository tournamentRepository;

  @Resource
  private PlayerProxy playerProxy;

  @Resource
  private GameProxy gameProxy;

  @Transactional
  public void createTournament(LocalDate date, List<PlayerDto> players) {
    Tournament tournament = new Tournament();
    tournament.setDate(date);
    tournament.setStages(players.size() / 2);

    tournament = tournamentRepository.save(tournament);

    List<GameDto> games = generateTournamentGridGames(tournament, players);
    ResponseEntity<HttpStatus> status = gameProxy.createGames(games);

    if (HttpStatus.BAD_REQUEST.equals(status.getStatusCode())) {
      compensateTournament(tournament);
    }
  }

  private List<GameDto> generateTournamentGridGames(Tournament tournament, List<PlayerDto> players) {
    List<GameDto> games = new ArrayList<>();

    players.sort(Comparator.comparingInt(PlayerDto::getScore).reversed());

    for (int i = 0; i < players.size(); i++) {
      GameDto game = new GameDto();
      game.setTournamentId(tournament.getId());
      game.setFirstPlayerId(players.get(i).getId());
      game.setSecondPlayerId(players.get(i + 1).getId());

      games.add(game);
    }

    return games;
  }

  public List<TournamentAndWinnerDto> getTournamentsAndWinners() {
    List<TournamentAndWinnerDto> tournamentWinners = new ArrayList<>();

    List<Tournament> tournaments = tournamentRepository.findAll();
    List<GameDto> gameWinners = gameProxy.getTournamentWinners();

    for (GameDto game : gameWinners) {
      TournamentAndWinnerDto tournamentWinner = new TournamentAndWinnerDto();
      tournamentWinner.setTournament(tournaments.stream().filter(t -> game.getTournamentId() == t.getId()).findFirst().get());
      tournamentWinner.setWinner(playerProxy.getPlayerById(game.getWinnerId()));
      tournamentWinners.add(tournamentWinner);
    }

    return tournamentWinners;
  }

  public List<TournamentWinnerDto> getTournamentWinners() {
    List<PlayerDto> winners = new ArrayList<>();

    List<GameDto> gamesAndWinners = gameProxy.getTournamentWinners();

    for (GameDto gameWinner : gamesAndWinners) {
      winners.add(playerProxy.getPlayerById(gameWinner.getWinnerId()));
    }

    return winners.stream()
        .collect(Collectors.groupingBy(player -> player, Collectors.counting()))
        .entrySet().stream()
        .map(entry -> new TournamentWinnerDto(entry.getKey(), entry.getValue()))
        .sorted(Collections.reverseOrder(Comparator.comparingInt(p -> p.getPlayer().getScore())))
        .toList();
  }

  private void compensateTournament(Tournament tournament) {
    tournamentRepository.deleteById(tournament.getId());
  }
}
