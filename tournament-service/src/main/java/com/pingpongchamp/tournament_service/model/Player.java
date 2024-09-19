package com.pingpongchamp.tournament_service.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ibodnar@amsoft-group.com
 * 
 * DELETE/REFACTOR ME
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Player {
  private long id;
  private String name;
  private LocalDate dateOfBirth;
}
