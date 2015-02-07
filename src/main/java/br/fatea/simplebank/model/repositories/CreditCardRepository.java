package br.fatea.simplebank.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.fatea.simplebank.model.domains.CreditCard;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {
	public CreditCard findOneByNumber(String number);
}