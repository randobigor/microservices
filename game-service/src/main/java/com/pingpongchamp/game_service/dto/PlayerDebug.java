package com.pingpongchamp.game_service.dto;

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
public class PlayerDebug {
  private Object player;
  private String environment;
}
