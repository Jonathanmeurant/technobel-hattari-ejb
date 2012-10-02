package be.technobel.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.technobel.domain.entity.User;
import be.technobel.domain.exceptions.ValidationException;
import be.technobel.services.interfaces.UserManagerBeanLocal;


/**
 * Session Bean implementation class UserManagerBean
 */
@Stateless
public class UserManagerBean implements UserManagerBeanLocal {
	
	@EJB(beanName = "UserRepositoryBean")
	private be.technobel.domain.repository.interfaces.user.UserRepository userRepository;
	
    public UserManagerBean() { 
    	
    }

	@Override
	public User login(String username, String password) {
		User user = null;
		if(username ==null || username.trim().length() ==0){
			throw new ValidationException("Invalid username ");
		}
		if(password == null || password.trim().isEmpty()){
			throw new ValidationException("Invalid password ");
		}
		user = userRepository.findByUsername(username);
		
		if(user == null || !user.getPassword().equals(password)){
			return null;
		}		
		return user;
	}
	
	public User register(User user) {

		if(user== null){
			throw new ValidationException("Invalid user");
		}
		
		if(user.getUsername() == null || user.getUsername().trim().length() == 0){
			throw new ValidationException("Invalid username");
		}
		
		if(user.getPassword() == null || user.getPassword().trim().length() == 0){
			throw new ValidationException("Invalid password");
		}
		if(user.getLastName() == null || user.getLastName().trim().length() == 0){
			throw new ValidationException("Invalid lastname");
		}
		
		if(user.getFirstName() == null || user.getFirstName().trim().length() == 0){
			throw new ValidationException("Invalid username");
		}
		
		if(user.getEmail() == null || user.getEmail().trim().length() == 0){
			throw new ValidationException("Invalid email");
		}
		
		if(user.getAvatar() == null || user.getAvatar().trim().length() == 0){
			throw new ValidationException("Invalid image");
		}
		
		User userverif = userRepository.findByUsername(user.getUsername());
		
		if(userverif != null){
			throw new ValidationException("username already exist");
		}
					
		
		return userRepository.save(user);
	}

}
