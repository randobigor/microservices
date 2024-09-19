package com.pingpongchamp.contracts;

import java.time.LocalDate;

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
public class PlayerDto {

  private Long id;
  private String name;
  private LocalDate dateOfBirth;
}
