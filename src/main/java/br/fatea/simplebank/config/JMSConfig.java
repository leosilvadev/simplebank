package br.fatea.simplebank.config;

import java.util.UUID;

import javax.annotation.Resource;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.support.converter.MessageConverter;

import br.fatea.simplebank.model.jms.converters.PaymentMessageConverter;
import br.fatea.simplebank.model.jms.mappers.JSONMapperTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@PropertySource("classpath:configuration/jms.properties")
public class JMSConfig {

	@Resource private Environment environment;
	
	@Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
//        PODE SER UTILIZADO COMO QUEUE PADRAO
//        jmsTemplate.setDefaultDestination(queuePayment());
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setMessageConverter(paymentMessageConverter());
        return jmsTemplate;
    }
	
	@Bean
	public ActiveMQTopic queuePayment(){
		return new ActiveMQTopic(environment.getProperty("jms.queue.payments_one"));
	}
	
	@Bean
	@Scope(value="prototype")
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(environment.getProperty("jms.broker.url"));
        activeMQConnectionFactory.setClientID(UUID.randomUUID().toString());
        return activeMQConnectionFactory;
    }

	@Bean
	public MessageListenerContainer chatMessageListenerContainer(){
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setDestination(new ActiveMQTopic(environment.getProperty("jms.topic.chat")));
		return container;
	}
	
	@Bean
	public MessageConverter paymentMessageConverter(){
		return new PaymentMessageConverter();
	}
	
	@Bean
	public JSONMapperTemplate jsonMapperTemplate(){
		return new JSONMapperTemplate(new ObjectMapper());
	}
	
}
