/**
 * 
 */
package be.technobel.domain.repository.interfaces.user;

import java.util.List;

import javax.persistence.TypedQuery;

import be.technobel.domain.entity.User;
import be.technobel.domain.repository.interfaces.GenericRepository;

/**
 * @author jonmeu
 *
 */

public interface UserRepository extends GenericRepository<User> {

	public User findByUsername(String username) ;		
}
