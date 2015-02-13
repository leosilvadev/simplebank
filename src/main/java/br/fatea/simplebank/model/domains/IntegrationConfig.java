package br.fatea.simplebank.model.domains;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IntegrationConfig {
	
	@Column(name="CFG_PAYMENT_QUEUE")
	private String paymentQueue;

	public String getPaymentQueue() {
		return paymentQueue;
	}

	public void setPaymentQueue(String paymentQueue) {
		this.paymentQueue = paymentQueue;
	}

}
