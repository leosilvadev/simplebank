package br.fatea.simplebank.config;

import java.util.UUID;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import br.fatea.simplebank.model.jms.converters.PaymentMessageConverter;

@Configuration
@EnableScheduling
@PropertySource("classpath:configuration/jms.properties")
public class JMSConfig {

	@Autowired private PaymentMessageConverter paymentMessageConverter;
	@Autowired private Environment environment;

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		jmsTemplate.setMessageConverter(paymentMessageConverter);
		return jmsTemplate;
	}

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(environment.getProperty("jms.broker.url"));
		activeMQConnectionFactory.setClientID(UUID.randomUUID().toString());
		return activeMQConnectionFactory;
	}

}