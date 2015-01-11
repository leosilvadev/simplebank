package br.fatea.simplebank.model.jms.converters;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import br.fatea.simplebank.model.jms.mappers.JSONMapperTemplate;
import br.fatea.simplebank.model.jms.messages.PaymentMessage;

@Component
public class PaymentMessageConverter implements MessageConverter {

	@Autowired private JSONMapperTemplate jsonMapperTemplate;

	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		return jsonMapperTemplate.mapToObject(message, PaymentMessage.class);
	}

	@Override
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		return jsonMapperTemplate.mapToMessage(object, session);
	}
	
}
