package br.fatea.simplebank.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.fatea.simplebank.model.domains.SystemUser;
import br.fatea.simplebank.model.repositories.SystemUserRepository;
import br.fatea.simplebank.model.services.SystemUserService;

@Controller
@RequestMapping("/users")
public class SystemUserController {

	@Autowired private SystemUserService systemUserService;
	@Autowired private SystemUserRepository systemUserRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("users", systemUserRepository.findAll());
		model.addAttribute("systemUser", new SystemUser());
		return "list_user";
	}

	@RequestMapping(value="/refresh", method=RequestMethod.GET)
	public String refresh(Model model){
		model.addAttribute("users", systemUserRepository.findAll());
		return "table_list_user";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<SystemUser> find(@PathVariable Long id){
		SystemUser systemUser = systemUserRepository.findOne(id);
		
		return new ResponseEntity<SystemUser>(systemUser, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		try {
			systemUserRepository.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> save(
			@ModelAttribute("systemUser") @Valid SystemUser systemUser, 
			BindingResult bindingResult){
		
		if ( bindingResult.hasErrors() ) {
			return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
			
		} else {
			try {
				systemUserService.save(systemUser);
				return new ResponseEntity<String>(HttpStatus.CREATED);
			
			} catch (DataIntegrityViolationException ex){
				return new ResponseEntity<String>("This user already exist", HttpStatus.BAD_REQUEST);
				
			}
			
		}
	}
	
}
