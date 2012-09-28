/**
 * 
 */
package be.technobel.services;

import be.technobel.domain.entity.User;

/**
 * @author student
 *
 */
public interface UserManager {

	public User login(String username, String password);
}
