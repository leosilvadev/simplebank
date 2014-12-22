package br.fatea.simplebank.model.resources;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="credit-card")
@JsonTypeName("credit-card")
public class CreditCardResource extends ResourceSupport {

	@NotNull @NotEmpty
	@XmlAttribute
	private String number;

	@NotNull
	private Integer code;

	@NotNull
	@XmlElement(name="validate-month")
	@JsonProperty("validate-month")
	private Integer validateMonth;

	@NotNull
	@XmlElement(name="validate-year")
	@JsonProperty("validate-year")
	private Integer validateYear;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getValidateMonth() {
		return validateMonth;
	}

	public void setValidateMonth(Integer validateMonth) {
		this.validateMonth = validateMonth;
	}

	public Integer getValidateYear() {
		return validateYear;
	}

	public void setValidateYear(Integer validateYear) {
		this.validateYear = validateYear;
	}
	
}
