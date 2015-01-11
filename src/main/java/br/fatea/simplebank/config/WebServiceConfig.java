package br.fatea.simplebank.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import br.fatea.simplebank.soap.interceptors.ValidationInterceptor;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		super.addInterceptors(interceptors);
		interceptors.add(soapValidationInterceptor());
	}
	
	@Bean
	public ValidationInterceptor soapValidationInterceptor(){
		ValidationInterceptor interceptor = new ValidationInterceptor();
		interceptor.setSchema(paymentXSDResource());
		interceptor.setValidateRequest(true);
		interceptor.setValidateResponse(false);
		return interceptor;
	}
	
	@Bean(name = "payment")
	public DefaultWsdl11Definition paymentWsdlDefinition() {
		DefaultWsdl11Definition wsdlDefinition = new DefaultWsdl11Definition();
		wsdlDefinition.setPortTypeName("paymentPort");
		wsdlDefinition.setLocationUri("/ws/payment");
		wsdlDefinition.setTargetNamespace("http://fatea.br/simplebank/soap/payment");
		wsdlDefinition.setSchema(paymentSchema());
		return wsdlDefinition;
	}

	@Bean
	public XsdSchema paymentSchema() {
		return new SimpleXsdSchema(paymentXSDResource());
	}

	@Bean
	public ClassPathResource paymentXSDResource(){
		return new ClassPathResource("models/payment.xsd");
	}
	
}
