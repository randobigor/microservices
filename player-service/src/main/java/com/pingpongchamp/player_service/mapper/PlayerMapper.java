package com.pingpongchamp.player_service.mapper;

import com.pingpongchamp.contracts.PlayerDto;
import com.pingpongchamp.player_service.model.Player;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author ibodnar@amsoft-group.com
 */

@Mapper(componentModel = "spring")
public interface PlayerMapper {

  @Mapping(source = "id", target = "id")
  PlayerDto toDto(Player player);
}
