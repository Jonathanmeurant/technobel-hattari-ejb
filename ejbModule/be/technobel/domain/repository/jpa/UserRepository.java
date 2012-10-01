package be.technobel.domain.repository.jpa;

import java.util.List;


import be.technobel.domain.entity.User;
import be.technobel.domain.exceptions.RepositoryException;
import be.technobel.domain.exceptions.ValidationException;
import be.technobel.domain.repository.interfaces.user.UserRepositoryLocal;
import be.technobel.domain.repository.jpa.generic.GenericRepositoryJpa;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class UserRepository
 */
@Stateless
public class UserRepository extends GenericRepositoryJpa<User>  implements UserRepositoryLocal {

 UserRepository() {
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
