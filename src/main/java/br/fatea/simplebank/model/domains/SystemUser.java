package br.fatea.simplebank.model.domains;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "TBL_SYSTEM_USER")
public class SystemUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SUS_ID")
	private Long id;
	
	@NotNull
	@NotEmpty
	@Column(name = "SUS_USERNAME", unique=true)
	private String username;
	
	@NotNull
	@NotEmpty
	@Column(name = "SUS_PASSWORD")
	private String password;
	
	@Version
	@Column(name = "SUS_VERSION")
	private Integer version;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TBL_SYSTEM_USER_ROLES", joinColumns = @JoinColumn(name = "SYSTEM_USER", referencedColumnName = "SUS_ID"), inverseJoinColumns = @JoinColumn(name = "SYSTEM_ROLE", referencedColumnName = "SRO_ID"))
	private Set<SystemRole> roles;

	@Embedded
	private IntegrationConfig integrationConfig;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Set<SystemRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SystemRole> roles) {
		this.roles = roles;
	}

	public IntegrationConfig getIntegrationConfig() {
		return integrationConfig;
	}

	public void setIntegrationConfig(IntegrationConfig integrationConfig) {
		this.integrationConfig = integrationConfig;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		SystemUser other = (SystemUser) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}