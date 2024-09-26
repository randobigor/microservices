package com.pingpongchamp.tournament_service.controller;

import com.pingpongchamp.tournament_service.dto.GameDto;
import com.pingpongchamp.tournament_service.dto.PlayerDto;
import com.pingpongchamp.tournament_service.dto.TournamentAndWinnerDto;
import com.pingpongchamp.tournament_service.dto.TournamentWinnerDto;
import com.pingpongchamp.tournament_service.service.TournamentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import jakarta.annotation.Resource;

/**
 * @author ibodnar@amsoft-group.com
 */

@RestController
@RequestMapping("/tournament")
public class TournamentController {

  @Resource
  private TournamentService tournamentService;

  @PostMapping("/create")
  public void createTournament(@RequestParam LocalDate date, @RequestBody List<PlayerDto> players) {
    tournamentService.createTournament(date, players);
  }

  @GetMapping("/tournaments-and-winners")
  public List<TournamentAndWinnerDto> getTournamentsAndWinners() {
    return tournamentService.getTournamentsAndWinners();
  }

  @GetMapping("/tournament-winners")
  public List<TournamentWinnerDto> getTournamentWinners() {
    return tournamentService.getTournamentWinners();
  }

  @GetMapping("/get-info-by-date")
  public ResponseEntity<Map<Integer, List<GameDto>>> getTournamentInfoByDate(@RequestParam LocalDate date) {
    return tournamentService.getTournamentInfo(date);
  }
}
