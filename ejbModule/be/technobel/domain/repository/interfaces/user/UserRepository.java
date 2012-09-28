/**
 * 
 */
package be.technobel.domain.repository.interfaces.user;

import java.util.List;

import be.technobel.domain.entity.User;
import be.technobel.domain.repository.interfaces.GenericRepository;

/**
 * @author jonmeu
 *
 */

public interface UserRepository extends GenericRepository<User> {

	public List<User> findRange(int start, int length); // ordered by username
	public List<User> findScoreRange(int minGames, int start, int length); // ordered by ratio, gamesPlayed >= minGames
}
