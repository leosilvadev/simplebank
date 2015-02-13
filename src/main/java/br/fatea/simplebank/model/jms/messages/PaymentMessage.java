package br.fatea.simplebank.model.jms.messages;

import br.fatea.simplebank.soap.payment.v1.PaymentStatus;
import br.fatea.simplebank.utils.DatetimeUtil;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("payment_message")
public class PaymentMessage {
	
	@JsonProperty(required = true)
	private String order;
	
	@JsonProperty(required = true)
	private PaymentStatus status;
	
	@JsonProperty(required = true, value = "generated_datetime")
	private String generatedDatetime;
	
	@JsonProperty(required = false, value = "detail")
	private String detail;

	public PaymentMessage() {
	}

	public PaymentMessage(String order, PaymentStatus status, String detail) {
		super();
		this.order = order;
		this.status = status;
		this.generatedDatetime = detail;
		this.generatedDatetime = DatetimeUtil.now(DatetimeUtil.PATTERN_SOAP_DATETIME);
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentMessage other = (PaymentMessage) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
}