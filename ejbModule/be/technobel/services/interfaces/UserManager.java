/**
 * 
 */
package be.technobel.services.interfaces;

import be.technobel.domain.entity.User;

/**
 * @author jonmeu
 *
 */
public interface UserManager {

	public User login(String username, String password);
	public User register(User user);
}
