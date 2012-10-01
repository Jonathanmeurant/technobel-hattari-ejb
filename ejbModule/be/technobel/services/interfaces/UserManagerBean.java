package be.technobel.services.interfaces;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.technobel.domain.entity.User;
import be.technobel.domain.exceptions.ValidationException;


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

}
