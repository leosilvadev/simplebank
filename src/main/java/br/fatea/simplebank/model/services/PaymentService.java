package br.fatea.simplebank.model.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatea.simplebank.model.converters.Converter;
import br.fatea.simplebank.model.domains.Payment;
import br.fatea.simplebank.model.repositories.PaymentRepository;
import br.fatea.simplebank.soap.payment.v1.PaymentRequest;
import br.fatea.simplebank.soap.payment.v1.PaymentResponse;
import br.fatea.simplebank.soap.payment.v1.PaymentStatus;
import br.fatea.simplebank.utils.DatetimeUtil;

@Service
public class PaymentService {

	@Autowired private PaymentRepository paymentRepository;
	@Autowired private Converter<PaymentRequest, Payment> converter;
	
	@Transactional
	public PaymentResponse process(PaymentRequest paymentRequest) {
		save(paymentRequest);
		return buildResponse(paymentRequest);
	}

	private PaymentResponse buildResponse(PaymentRequest paymentRequest) {
		PaymentResponse response = new PaymentResponse();
		response.setOrder(paymentRequest.getOrder());
		response.setStatus(PaymentStatus.OPENED);
		response.setProcessDate(DatetimeUtil.now(DatetimeUtil.PATTERN_SOAP_DATETIME));
		return response;
	}

	private void save(PaymentRequest paymentRequest) {
		Payment payment = converter.asDomain(paymentRequest);
		payment.setStatus(PaymentStatus.OPENED);
		paymentRepository.save(payment);
	}
}