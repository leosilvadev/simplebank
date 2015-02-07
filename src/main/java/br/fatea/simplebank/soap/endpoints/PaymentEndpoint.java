package br.fatea.simplebank.soap.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.fatea.simplebank.model.services.PaymentService;
import br.fatea.simplebank.soap.payment.v1.PaymentRequest;
import br.fatea.simplebank.soap.payment.v1.PaymentResponse;

@Endpoint
public class PaymentEndpoint {
	
	private static final String NAMESPACE_URI = "http://fatea.br/simplebank/soap/payment/v1";
	
	@Autowired private PaymentService paymentService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "PaymentRequest")
	@ResponsePayload
	public PaymentResponse payment(@RequestPayload PaymentRequest paymentRequest) {
		return paymentService.process(paymentRequest);
	}
	
}
