package com.codingdojo.tictactoe.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.tictactoe.models.LoginUser;
import com.codingdojo.tictactoe.models.User;
import com.codingdojo.tictactoe.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findUsers(){
		return userRepository.findAll();
	}
	
	public User register(User newUser, BindingResult result) {
		Boolean valid = true;
		
		Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "This email already has an account attached to it.");
			valid = false;
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The confirming password must match the password.");
			valid = false;
		}
		if (result.hasErrors()) valid = false;
		
		if(valid) {
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			return userRepository.save(newUser);
		}else {
			return null;
		}	
	}
	
	public User login(LoginUser newLoginObject, BindingResult result) {
		
		Optional<User> potentialUser = userRepository.findByEmail(newLoginObject.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "Unknown Password or Email");	
			return null;
		}
		
		//If we get here, the user does exist
		User userInDatabase = potentialUser.get();
		
		
		if(!BCrypt.checkpw(newLoginObject.getPassword(), userInDatabase.getPassword())) {
			result.rejectValue("password", "Matches", "Unknown Password or Email");
			return null;
		} else {
			return potentialUser.get();
		}
	}
	
	public User findUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
}
