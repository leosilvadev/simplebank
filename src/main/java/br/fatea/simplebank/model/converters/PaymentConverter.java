package br.fatea.simplebank.model.converters;

import org.springframework.stereotype.Component;

import br.fatea.simplebank.model.domains.CreditCard;
import br.fatea.simplebank.model.domains.Payment;
import br.fatea.simplebank.model.domains.ValidationDate;
import br.fatea.simplebank.soap.payment.v1.PaymentRequest;
import br.fatea.simplebank.utils.DatetimeUtil;

@Component
public class PaymentConverter implements Converter<PaymentRequest, Payment> {

	@Override
	public PaymentRequest asDTO(Payment domain) {
		return null;
	}

	@Override
	public Payment asDomain(PaymentRequest dto) {
		CreditCard creditCard = buildDomainCreditCard(dto);
		return buildDomainPayment(dto, creditCard);
	}
	
	private Payment buildDomainPayment(PaymentRequest dto, CreditCard creditCard){
		Payment payment = new Payment();
		payment.setOrder(dto.getOrder());
		payment.setRegistrationDate(
			DatetimeUtil.asCalendar(dto.getRegistrationDate(), DatetimeUtil.PATTERN_SOAP_DATETIME)
		);
		payment.setCreditCard(creditCard);
		return payment;
	}
	
	private CreditCard buildDomainCreditCard(PaymentRequest dto){
		CreditCard creditCard = new CreditCard();
		creditCard.setOwnerName(dto.getCreditCard().getOwnerName());
		creditCard.setCode(dto.getCreditCard().getCode());
		creditCard.setNumber(dto.getCreditCard().getCardNumber());
		creditCard.setValidationDate(
				new ValidationDate(dto.getCreditCard().getValidMonth(), dto.getCreditCard().getValidYear())
		);
		return creditCard;
	}

}
