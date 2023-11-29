package com.kafka.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafka.producer.model.UserModel;


@Service
public class TopicJsonService {
	
private static final Logger LOGGER =  LoggerFactory.getLogger(TopicJsonService.class);
	
	private KafkaTemplate<String, UserModel> kafkaTemplate;

	public TopicJsonService(KafkaTemplate<String, UserModel> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(UserModel data) {
		
		LOGGER.info(String.format("Message send -> %s", data.toString()));
		
		Message<UserModel> message = MessageBuilder
				.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC, "topic_json")
				.build();
		
		kafkaTemplate.send(message);
	}
	

}
