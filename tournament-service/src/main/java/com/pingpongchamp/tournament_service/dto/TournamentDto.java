package com.pingpongchamp.tournament_service.dto;

import java.util.List;

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
public class TournamentDto {

  private Integer stage;
  private List<TournamentGameDto> game;
}
