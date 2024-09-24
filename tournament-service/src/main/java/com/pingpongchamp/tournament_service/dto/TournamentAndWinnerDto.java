package com.pingpongchamp.tournament_service.dto;

import com.pingpongchamp.common.dtos.PlayerDto;
import com.pingpongchamp.tournament_service.model.Tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ibodnar@amsoft-group.com
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TournamentAndWinnerDto {

  private Tournament tournament;
  private PlayerDto winner;
}
