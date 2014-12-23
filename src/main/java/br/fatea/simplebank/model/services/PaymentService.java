package br.fatea.simplebank.model.services;

import org.springframework.stereotype.Service;

import br.fatea.simplebank.soap.payment.PaymentRequest;
import br.fatea.simplebank.soap.payment.PaymentResponse;

@Service
public class PaymentService {

	public PaymentResponse pay(PaymentRequest paymentRequest){
		//TODO: MISSING FAKE IMPLEMENTATION
		return new PaymentResponse();
	}
	
}
