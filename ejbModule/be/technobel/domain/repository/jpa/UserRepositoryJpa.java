package be.technobel.domain.repository.jpa;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import be.technobel.domain.entity.User;
import be.technobel.domain.exceptions.ValidationException;
import be.technobel.domain.repository.interfaces.user.UserRepositoryLocal;
import be.technobel.domain.repository.jpa.generic.GenericRepositoryJpa;

/**
 * Session Bean implementation class UserRepository
 */
@Stateless(name="UserRepositoryBean")
public class UserRepositoryJpa extends GenericRepositoryJpa<User>  implements UserRepositoryLocal {

	public UserRepositoryJpa() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public User findByUsername(String username) {
		if(username == null || username.trim().length() ==0){
			throw new ValidationException("Invalid username");
		}
		TypedQuery<User> query = em.createNamedQuery("User.findByUsername", User.class);
		query.setParameter("username", username);		
		return query.getSingleResult();		
	}

}
