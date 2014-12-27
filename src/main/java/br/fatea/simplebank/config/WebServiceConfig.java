package br.fatea.simplebank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	@Bean(name = "payment")
	public DefaultWsdl11Definition defaultWsdl11Definition() {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("paymentPort");
		wsdl11Definition.setLocationUri("/ws/payment");
		wsdl11Definition.setTargetNamespace("http://fatea.br/simplebank/soap/payment");
		wsdl11Definition.setSchema(paymentSchema());
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema paymentSchema() {
		return new SimpleXsdSchema(new ClassPathResource("models/payment.xsd"));
	}
	
}
