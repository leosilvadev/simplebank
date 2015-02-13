package br.fatea.simplebank.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.fatea.simplebank.model.converters.Converter;
import br.fatea.simplebank.model.domains.Payment;
import br.fatea.simplebank.model.domains.SystemUser;
import br.fatea.simplebank.model.jms.messages.PaymentMessage;
import br.fatea.simplebank.model.repositories.PaymentRepository;
import br.fatea.simplebank.model.repositories.SystemUserRepository;
import br.fatea.simplebank.model.templates.PaymentJMSTemplate;
import br.fatea.simplebank.soap.payment.v1.PaymentRequest;
import br.fatea.simplebank.soap.payment.v1.PaymentResponse;
import br.fatea.simplebank.soap.payment.v1.PaymentStatus;
import br.fatea.simplebank.utils.DatetimeUtil;

@Service
public class PaymentService {

	@Autowired private PaymentJMSTemplate paymentJMSTemplate;
	@Autowired private SystemUserRepository systemUserRepository;
	@Autowired private PaymentRepository paymentRepository;
	@Autowired private Converter<PaymentRequest, Payment> converter;
	
	@Transactional
	public void updateStatusPayments(PaymentStatus oldStatus, PaymentStatus newStatus, String detail) {
		List<Payment> payments = paymentRepository.findAllByStatus(oldStatus);
		for(Payment payment : payments) {
			payment.setStatus(newStatus);
			PaymentMessage message = new PaymentMessage(payment.getOrder(), payment.getStatus(), detail);
			paymentJMSTemplate.send(message, payment.getOwner().getIntegrationConfig().getPaymentQueue());
		}
	}
	
	@Transactional
	public PaymentResponse process(PaymentRequest paymentRequest, String username) {
		SystemUser systemUser = systemUserRepository.findOneByUsername(username);
		save(paymentRequest, systemUser);
		return buildResponse(paymentRequest);
	}

	private PaymentResponse buildResponse(PaymentRequest paymentRequest) {
		PaymentResponse response = new PaymentResponse();
		response.setOrder(paymentRequest.getOrder());
		response.setStatus(PaymentStatus.OPENED);
		response.setProcessDate(DatetimeUtil.now(DatetimeUtil.PATTERN_SOAP_DATETIME));
		return response;
	}

	private void save(PaymentRequest paymentRequest, SystemUser systemUser) {
		Payment payment = converter.asDomain(paymentRequest);
		payment.setOwner(systemUser);
		payment.setStatus(PaymentStatus.OPENED);
		paymentRepository.save(payment);
	}
	
}
