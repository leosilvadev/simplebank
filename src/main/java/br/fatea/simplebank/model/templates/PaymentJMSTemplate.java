package br.fatea.simplebank.model.templates;

import java.util.HashMap;
import java.util.Map;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import br.fatea.simplebank.model.jms.messages.PaymentMessage;

@Component
public class PaymentJMSTemplate {
	
	@Autowired private JmsTemplate jmsTemplate;
	
	private Map<String, ActiveMQQueue> queues;

	public PaymentJMSTemplate() {
		this.queues = new HashMap<>();
	}

	public void send(PaymentMessage message, String queueName) {
		ActiveMQQueue queue;
		if (!queues.containsKey(queueName)) {
			queues.put(queueName, new ActiveMQQueue(queueName));
		}
		queue = queues.get(queueName);
		jmsTemplate.convertAndSend(queue, message);
	}
}