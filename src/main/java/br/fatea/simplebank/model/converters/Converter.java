package br.fatea.simplebank.model.converters;

public interface Converter<DTO, DOMAIN> {

	DTO asDTO(DOMAIN domain);
	
	DOMAIN asDomain(DTO dto);
	
}
