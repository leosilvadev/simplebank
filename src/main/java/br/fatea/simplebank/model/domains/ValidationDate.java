package br.fatea.simplebank.model.domains;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class ValidationDate {
	
	@NotNull
	@Column(name="CRC_VALIDATION_MONTH")
	private Integer month;

	@NotNull
	@Column(name="CRC_VALIDATION_YEAR")
	private Integer year;

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
