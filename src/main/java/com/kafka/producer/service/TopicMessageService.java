package com.kafka.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TopicMessageService {
	
	// This produces the Kafka String Messages

	public static final Logger LOGGER = LoggerFactory.getLogger(TopicMessageService.class);
		
	private KafkaTemplate<String, String> kafkaTemplate;

	public TopicMessageService(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
		
	public void sendMessage(String message) {
		LOGGER.info(String.format("Message sent %s", message));
		kafkaTemplate.send("topicMessage", message);
	}

}
