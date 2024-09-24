package com.pingpongchamp.tournament_service.controller;

import com.pingpongchamp.tournament_service.dto.TournamentWinnerDto;
import com.pingpongchamp.tournament_service.model.Tournament;
import com.pingpongchamp.tournament_service.service.TournamentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
  public void createTournament() {

  }

  @GetMapping("/winners")
  public List<TournamentWinnerDto> getTournamentWinners() {
    return tournamentService.getTournamentWinners();
  }

  @GetMapping("/tournaments-general-info")
  public void some1() {
    //tournaments and winners (ordered by date desc)
  }

  @GetMapping("/get-info-by-date")
  public Tournament some() {
    return null;
  }
}
