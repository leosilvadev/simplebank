package br.fatea.simplebank.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.fatea.simplebank.model.domains.SystemUser;

@Repository
public interface SystemUserRepository extends CrudRepository<SystemUser, Long> {

	SystemUser findOneByUsername(String username);
	
}
