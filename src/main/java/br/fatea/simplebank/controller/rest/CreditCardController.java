package br.fatea.simplebank.controller.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.fatea.simplebank.model.domains.CreditCard;
import br.fatea.simplebank.model.resources.CreditCardResource;
import br.fatea.simplebank.model.resources.DefaultResource;
import br.fatea.simplebank.model.services.CreditCardService;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {
	
	@Autowired
	private CreditCardService creditCardService;

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<DefaultResource> save(@RequestBody @Valid CreditCardResource resource, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ResponseEntity<DefaultResource>(HttpStatus.BAD_REQUEST);
			
		} else {
			CreditCard creditCard = creditCardService.save(resource);
			DefaultResource defaultResource = new DefaultResource();
			defaultResource.addLink(linkTo(methodOn(this.getClass()).findByNumber(creditCard.getNumber())).withSelfRel());
			return new ResponseEntity<DefaultResource>(defaultResource, HttpStatus.CREATED);
			
		}
	}
	
	@RequestMapping(value="/{number}", method=RequestMethod.GET)
	public ResponseEntity<CreditCardResource> findByNumber(@PathVariable String number){
		CreditCardResource creditCard = creditCardService.findByNumber(number);
		return new ResponseEntity<CreditCardResource>(creditCard, HttpStatus.OK);
	}
	
}
