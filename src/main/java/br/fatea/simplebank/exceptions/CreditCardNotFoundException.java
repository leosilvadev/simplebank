package br.fatea.simplebank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NO_CONTENT, reason="Credit Card not found")
public class CreditCardNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 9068310938661770591L;

}
