package com.pingpongchamp.player_service.dto;

import java.time.LocalDate;
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
public class DefeatedPlayerDto {
  private String opponentName;
  private LocalDateTime gameStartTime;
  private String finalScore;
  private Integer duration;
}
