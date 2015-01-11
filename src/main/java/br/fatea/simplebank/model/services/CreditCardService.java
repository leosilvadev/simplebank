package br.fatea.simplebank.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatea.simplebank.exceptions.CreditCardNotFoundException;
import br.fatea.simplebank.model.domains.CreditCard;
import br.fatea.simplebank.model.domains.ValidationDate;
import br.fatea.simplebank.model.repositories.CreditCardRepository;
import br.fatea.simplebank.model.resources.v1.CreditCardResource;

@Service
public class CreditCardService {

	@Autowired
	private CreditCardRepository creditCardRepository;
	
	public CreditCardResource findByNumber(String number){
		CreditCard creditCard = creditCardRepository.findOneByNumber(number);
		if(creditCard==null) throw new CreditCardNotFoundException();
		
		CreditCardResource creditCardResource = new CreditCardResource();
		creditCardResource.setCode(creditCard.getCode());
		creditCardResource.setNumber(creditCard.getNumber());
		creditCardResource.setValidateMonth(creditCard.getValidationDate().getMonth());
		creditCardResource.setValidateYear(creditCard.getValidationDate().getYear());
		creditCardResource.setOwner(creditCard.getOwnerName());
		return creditCardResource;
	}

	public CreditCard save(CreditCardResource resource) {
		CreditCard creditCard = new CreditCard();
		creditCard.setCode(resource.getCode());
		creditCard.setNumber(resource.getNumber());
		creditCard.setOwnerName(resource.getOwner());
		
		ValidationDate validationDate = new ValidationDate();
		validationDate.setMonth(resource.getValidateMonth());
		validationDate.setYear(resource.getValidateYear());
		
		creditCard.setValidationDate(validationDate);
		
		return creditCardRepository.save(creditCard);
	}
	
}
