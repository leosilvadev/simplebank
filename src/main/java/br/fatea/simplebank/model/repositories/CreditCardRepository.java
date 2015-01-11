package br.fatea.simplebank.model.repositories;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.fatea.simplebank.model.domains.CreditCard;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Long>, QueryDslPredicateExecutor<CreditCard> {

	public CreditCard findOneByNumber(String number);
	
}
