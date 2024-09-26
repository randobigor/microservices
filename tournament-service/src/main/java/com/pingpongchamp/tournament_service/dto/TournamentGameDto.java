package com.pingpongchamp.tournament_service.dto;

import java.time.LocalDateTime;

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
public class TournamentGameDto {
  private long firstPlayerId;
  private long secondPlayerId;
  private LocalDateTime startDateTime;
  private String finalScore;
  private Long winnerId;
  private Integer duration;
}
