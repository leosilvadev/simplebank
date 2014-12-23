package br.fatea.simplebank.soap.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.fatea.simplebank.model.services.PaymentService;
import br.fatea.simplebank.soap.payment.PaymentRequest;
import br.fatea.simplebank.soap.payment.PaymentResponse;

@Endpoint
public class PaymentEndpoint {
	
	private static final String NAMESPACE_URI = "http://fatea.br/simplebank/soap/payment";
	
	@Autowired private PaymentService paymentService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "paymentRequest")
	@ResponsePayload
	public PaymentResponse payment(@RequestPayload PaymentRequest paymentRequest){
		return paymentService.pay(paymentRequest);
	}

}
