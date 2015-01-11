package br.fatea.simplebank.model.jms.mappers;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONMapperTemplate {

	private ObjectMapper objectMapper;
	
	public JSONMapperTemplate(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
	
	public <T> T mapToObject(Message message, Class<T> clazz){
		if(message instanceof TextMessage){
			TextMessage textMessage = (TextMessage) message;
			try {
				return objectMapper.readValue(textMessage.getText(), clazz);
				
			} catch (IOException | JMSException e) {
	            throw new IllegalArgumentException("Invalid Message");
				
			}
			
		} else {
            throw new IllegalArgumentException("Invalid Message. Message must be of type TextMessage");
			
		}
	}
	
	public Message mapToMessage(Object object, Session session){
		try {
			return session.createTextMessage(objectMapper.writeValueAsString(object));
			
		} catch (JsonProcessingException | JMSException e) {
            throw new IllegalArgumentException("Invalid Message");
            
		}
	}
	
}
