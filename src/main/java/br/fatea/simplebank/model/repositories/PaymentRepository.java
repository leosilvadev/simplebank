package br.fatea.simplebank.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.fatea.simplebank.model.domains.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
