package com.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.model.UserModel;
import com.kafka.producer.service.TopicJsonService;

@RestController
@RequestMapping("/api/kafka")
public class TopicJsonController {
	
	@Autowired
	private TopicJsonService jsonService;
	
	@PostMapping("/publish/json")
	public ResponseEntity<String> publish(@RequestBody UserModel model) {
		
		jsonService.sendMessage(model);
		return ResponseEntity.ok("Json Message send to kafka Topic");
		
	}

}
