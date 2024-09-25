package com.pingpongchamp.common.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class GameDto {
  private long id;
  private long tournamentId;
  private long firstPlayerId;
  private long secondPlayerId;
  private LocalDateTime startDateTime;
  private String finalScore;
  private Long winnerId;
  private Integer duration;
  private Integer stage;
}