package br.fatea.simplebank.soap.endpoints;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;

import br.fatea.simplebank.model.services.PaymentService;
import br.fatea.simplebank.soap.payment.v1.PaymentRequest;
import br.fatea.simplebank.soap.payment.v1.PaymentResponse;

@Endpoint
public class PaymentEndpoint {
	
	private static final String NAMESPACE_URI = "http://fatea.br/simplebank/soap/payment/v1";
	private static final String BASIC = "Basic ";

	@Autowired private PaymentService paymentService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "PaymentRequest")
	@ResponsePayload
	public PaymentResponse payment(
			@RequestPayload PaymentRequest paymentRequest) {
		
		return paymentService.process(paymentRequest, findUserName());
	}
	
	private String findUserName(){
		String authorization = getHttpHeaderValue("Authorization").split(BASIC)[1];
		String decodedAuthorization = new String(Base64.decode(authorization.getBytes()));
		String username = decodedAuthorization.split(":")[0];
		return username;
	}
	
	private HttpServletRequest getHttpServletRequest() {
	    TransportContext ctx = TransportContextHolder.getTransportContext();
	    return ((HttpServletConnection) ctx.getConnection()).getHttpServletRequest();
	}

	private String getHttpHeaderValue(String headerName) {
	    HttpServletRequest httpServletRequest = getHttpServletRequest();
	    return httpServletRequest.getHeader(headerName);
	}
	
}
