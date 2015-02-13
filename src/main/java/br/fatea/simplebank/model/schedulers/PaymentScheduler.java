package br.fatea.simplebank.model.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.fatea.simplebank.model.services.PaymentService;
import br.fatea.simplebank.soap.payment.v1.PaymentStatus;

@Component
public class PaymentScheduler {
	
	@Autowired private PaymentService paymentService;
	
	@Scheduled(fixedDelay = 10 * 1000)
	public void confirmPayments(){
		paymentService.updateStatusPayments(PaymentStatus.OPENED, PaymentStatus.CONFIRMED, null);
	}
	
	@Scheduled(fixedDelay = 20 * 1000)
	public void cancelPayments(){
		paymentService.updateStatusPayments(PaymentStatus.OPENED, PaymentStatus.CANCELED, "No limit available");
	}
	
}
