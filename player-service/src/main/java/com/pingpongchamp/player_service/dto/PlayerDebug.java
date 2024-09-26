package com.pingpongchamp.player_service.dto;

import com.pingpongchamp.player_service.model.Player;

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
@Setter
@Getter
@Builder
public class PlayerDebug {

  private Player player;
  private String environment;
}
