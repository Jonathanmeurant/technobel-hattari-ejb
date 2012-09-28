package be.technobel.domain.repository.jpa;

import java.util.List;


import be.technobel.domain.entity.User;
import be.technobel.domain.exceptions.RepositoryException;
import be.technobel.domain.repository.interfaces.user.UserRepositoryLocal;
import be.technobel.domain.repository.jpa.generic.GenericRepositoryJpa;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class UserRepository
 */
@Stateless
public class UserRepository extends GenericRepositoryJpa<User>  implements UserRepositoryLocal {

    /**
     * Default constructor. 
     */
    public UserRepository() {
        // TODO Auto-generated constructor stub
    }

	

}
