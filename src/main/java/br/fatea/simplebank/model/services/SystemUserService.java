package br.fatea.simplebank.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.fatea.simplebank.model.domains.SystemUser;
import br.fatea.simplebank.model.repositories.SystemUserRepository;

@Service
@Transactional
public class SystemUserService {
	
	@Autowired private BCryptPasswordEncoder encoder;
	@Autowired private SystemUserRepository systemUserRepository;
	
	public void save(SystemUser systemUser){
		systemUser.encodePassword(encoder);
		if ( systemUser.getId()==null ) {
			systemUserRepository.save(systemUser);
			
		} else {
			SystemUser persistedUser = systemUserRepository.findOne(systemUser.getId());
			persistedUser.setUsername(systemUser.getUsername());
			persistedUser.setPassword(systemUser.getPassword());
			
		}
	}

}
