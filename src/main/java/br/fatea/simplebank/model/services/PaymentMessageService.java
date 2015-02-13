package br.fatea.simplebank.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatea.simplebank.model.jms.messages.PaymentMessage;
import br.fatea.simplebank.model.templates.PaymentJMSTemplate;

@Service
public class PaymentMessageService {
	
	@Autowired private PaymentJMSTemplate paymentJMSTemplate;

	public void send(PaymentMessage message, String queueName) {
		paymentJMSTemplate.send(message, queueName);
	}
}