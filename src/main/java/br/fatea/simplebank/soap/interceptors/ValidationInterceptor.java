package br.fatea.simplebank.soap.interceptors;

import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.xml.sax.SAXException;

import br.fatea.simplebank.soap.exceptions.InvalidClientArgumentsException;

public class ValidationInterceptor extends PayloadValidatingInterceptor {

	protected Source getValidationRequestSource(WebServiceMessage request) {
		Source source = request.getPayloadSource();
		validateSchema(source);
		return source;
	}

	private void validateSchema(Source source) {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(getSchemaLanguage());
		try {
			Schema schema = schemaFactory.newSchema(getSchemas()[0].getFile());
			Validator validator = schema.newValidator();
			DOMResult result = new DOMResult();
			try {
				validator.validate(source, result);
				
			} catch (SAXException ex) {
				logger.error(ex);
				throw new InvalidClientArgumentsException(ex.getMessage());
				
			}
			
		} catch (SAXException | IOException ex) { logger.error(ex); }
	}

}
