package br.fatea.simplebank.model.jms.messages;

import br.fatea.simplebank.soap.payment.v1.PaymentStatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("payment_message")
public class PaymentMessage {

	@JsonProperty(required=true)
	private String order;

	@JsonProperty(required=true)
	private PaymentStatus status;

	@JsonProperty(required=true, value="generated_datetime")
	private String generatedDatetime;
	
	public PaymentMessage() {}
	
	public PaymentMessage(String order, PaymentStatus status, String generatedDatetime) {
		super();
		this.order = order;
		this.status = status;
		this.generatedDatetime = generatedDatetime;
	}
	
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public String getGeneratedDatetime() {
		return generatedDatetime;
	}

	public void setGeneratedDatetime(String generatedDatetime) {
		this.generatedDatetime = generatedDatetime;
	}

}
