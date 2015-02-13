package br.fatea.simplebank.controllers.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
import br.fatea.simplebank.model.resources.v1.CreditCardResource;
import br.fatea.simplebank.model.resources.v1.HTTPResource;
import br.fatea.simplebank.model.services.CreditCardService;

@RestController
@RequestMapping("/v1/creditcard")
public class CreditCardController {
	
	@Autowired private CreditCardService creditCardService;

	@RequestMapping(value = "/{number}", method = RequestMethod.GET)
	public ResponseEntity<CreditCardResource> findByNumber(@PathVariable String number) {
		CreditCardResource resource = creditCardService.findByNumber(number);
		return new ResponseEntity<CreditCardResource>(resource, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<HTTPResource> save(
			@RequestBody @Valid CreditCardResource resource,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<HTTPResource>(HttpStatus.BAD_REQUEST);
			
		} else {
			CreditCard creditCard = creditCardService.save(resource);
			HTTPResource resourceResponse = new HTTPResource();
			resourceResponse.add(
				linkTo(
					methodOn(this.getClass()).findByNumber(creditCard.getNumber())
				).withSelfRel()
			);
			resourceResponse.add(
				linkTo(
					methodOn(this.getClass()).update(resource, creditCard.getNumber(), bindingResult)
				).withRel("update")
			);
			return new ResponseEntity<HTTPResource>(resourceResponse, HttpStatus.CREATED);
			
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/{number}")
	public ResponseEntity<HTTPResource> update(
			@RequestBody @Valid CreditCardResource resource,
			@PathVariable String number,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<HTTPResource>(HttpStatus.BAD_REQUEST);
			
		} else {
			CreditCard creditCard = creditCardService.update(number, resource);
			HTTPResource resourceResponse = new HTTPResource();
			resourceResponse.add(
				linkTo(
					methodOn(this.getClass()).findByNumber(creditCard.getNumber())
				).withSelfRel()
			);
			resourceResponse.add(
				linkTo(
					methodOn(this.getClass()).update(resource, creditCard.getNumber(), bindingResult)
				).withRel("update")
			);
			return new ResponseEntity<HTTPResource>(resourceResponse, HttpStatus.OK);
			
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{number}")
	public ResponseEntity<HTTPResource> delete(@PathVariable String number) {
		if (number==null || number.isEmpty()) {
			return new ResponseEntity<HTTPResource>(HttpStatus.BAD_REQUEST);
			
		} else {
			creditCardService.delete(number);
			return new ResponseEntity<HTTPResource>(HttpStatus.OK);
			
		}
	}
	
}