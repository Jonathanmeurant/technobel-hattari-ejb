package be.technobel.domain.repository.jpa;

import java.util.List;


import be.technobel.domain.entity.User;
import be.technobel.domain.repository.interfaces.user.UserRepositoryLocal;
import be.technobel.domain.repository.jpa.generic.GenericRepositoryJpa;

import javax.ejb.Stateless;

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

	@Override
	public List<User> findRange(int start, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findScoreRange(int minGames, int start, int length) {
		// TODO Auto-generated method stub
		return null;
	}

}
