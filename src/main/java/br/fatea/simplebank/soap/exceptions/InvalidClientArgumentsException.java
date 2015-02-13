package br.fatea.simplebank.soap.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode=FaultCode.CLIENT, faultStringOrReason="Invalid Request Parameters")
public class InvalidClientArgumentsException extends RuntimeException {

	private static final long serialVersionUID = -2188675525576989114L;

	public InvalidClientArgumentsException(String details) {
		super(details);
	}
	
}
