package com.pingpongchamp.common.dtos;

import java.time.LocalDate;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerDto {
  private Long id;
  private String name;
  private LocalDate dateOfBirth;
  private Integer score;
  private Integer tournamentsWon;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PlayerDto player = (PlayerDto) o;

    return Objects.equals(id, player.id);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
