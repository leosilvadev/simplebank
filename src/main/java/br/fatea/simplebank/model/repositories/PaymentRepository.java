package br.fatea.simplebank.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.fatea.simplebank.model.domains.Payment;
import br.fatea.simplebank.soap.payment.v1.PaymentStatus;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

	public List<Payment> findAllByStatus(PaymentStatus status);
	
}
