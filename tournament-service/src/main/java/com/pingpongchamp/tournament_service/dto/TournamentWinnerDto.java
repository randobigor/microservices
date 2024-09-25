package com.pingpongchamp.tournament_service.dto;


import com.pingpongchamp.common.dto.PlayerDto;

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
public class TournamentWinnerDto {
  
  private PlayerDto player;
  private long tournamentsWon;
}
