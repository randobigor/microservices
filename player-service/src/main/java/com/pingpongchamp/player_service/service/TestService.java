package com.pingpongchamp.player_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author ibodnar@amsoft-group.com
 */
@Service
public class TestService {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @KafkaListener(topics = "test-topic", groupId = "test")
  public void receive(String name) {
    System.out.println("Hello " + name);

    
  }
}
