package com.pingpongchamp.game_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ibodnar@amsoft-group.com
 */
@Entity
@Table(name = "games")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "first_player_id")
  private long firstPlayer;

  @Column(name = "second_player_id")
  private long secondPlayer;

  @Column(name = "start_tm")
  private LocalDateTime startTm;

  @Column(name = "final_score")
  private String finalScore;

  @Column(name = "winner_id")
  private long winnerId;

  @Column(name = "duration")
  private int duration;
}
