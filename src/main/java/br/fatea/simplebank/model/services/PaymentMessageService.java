package br.fatea.simplebank.model.services;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import br.fatea.simplebank.model.jms.messages.PaymentMessage;

@Service
public class PaymentMessageService {

	@Autowired private JmsTemplate jmsTemplate;
	@Autowired private ActiveMQTopic queuePayment;
	
	public void send(PaymentMessage message) {
		jmsTemplate.convertAndSend(queuePayment, message);
	}
	
}
