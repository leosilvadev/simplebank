package br.fatea.simplebank.model.domains;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

import br.fatea.simplebank.soap.payment.PaymentStatus;

@Entity
@Table(name="TBL_PAYMENT")
@Audited
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PAY_ID")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name="PAY_STATUS")
	@NotNull
	private PaymentStatus status;

	@Column(name="PAY_REG_DATE")
	@NotNull
	private Calendar registrationDate;

	@ManyToOne(optional=false, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="CRC_ID")
	private CreditCard creditCard;

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public Calendar getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creditCard == null) ? 0 : creditCard.hashCode());
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
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
		Payment other = (Payment) obj;
		if (creditCard == null) {
			if (other.creditCard != null)
				return false;
		} else if (!creditCard.equals(other.creditCard))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		return true;
	}
	
}
