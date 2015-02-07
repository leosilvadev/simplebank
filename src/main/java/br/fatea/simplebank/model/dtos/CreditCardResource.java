package br.fatea.simplebank.model.dtos;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "credit_card")
@JsonTypeName("credit_card")
public class CreditCardResource {
	
	@NotNull
	@NotEmpty
	@XmlAttribute
	private String number;
	
	@NotNull
	@NotEmpty
	private String owner;
	
	@NotNull
	private Integer code;
	
	@NotNull
	@XmlElement(name = "validate_month")
	@JsonProperty("validate_month")
	private Integer validateMonth;
	
	@NotNull
	@XmlElement(name = "validate_year")
	@JsonProperty("validate_year")
	private Integer validateYear;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result
				+ ((validateMonth == null) ? 0 : validateMonth.hashCode());
		result = prime * result
				+ ((validateYear == null) ? 0 : validateYear.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCardResource other = (CreditCardResource) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (validateMonth == null) {
			if (other.validateMonth != null)
				return false;
		} else if (!validateMonth.equals(other.validateMonth))
			return false;
		if (validateYear == null) {
			if (other.validateYear != null)
				return false;
		} else if (!validateYear.equals(other.validateYear))
			return false;
		return true;
	}
	
}
