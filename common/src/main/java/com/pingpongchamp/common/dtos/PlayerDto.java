package com.pingpongchamp.common.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerDto {
  private long id;
  private String name;
  private LocalDate dateOfBirth;
  private Integer score;
}
