/**
 * 
 */
package be.technobel.domain.repository.interfaces.user;

import be.technobel.domain.entity.User;
import be.technobel.domain.repository.interfaces.GenericRepository;

/**
 * @author jonmeu
 *
 */

public interface UserRepository extends GenericRepository<User> {

	public User findByUsername(String username) ;		
}
