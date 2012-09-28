/**
 * 
 */
package be.technobel.domain.repository.interfaces.score;

import java.util.List;

import be.technobel.domain.entity.Score;
import be.technobel.domain.entity.User;
import be.technobel.domain.repository.interfaces.GenericRepository;

/**
 * @author jonmeu
 *
 */

public interface ScoreRepository extends GenericRepository<Score> {

	public List<Score> findRange(int start, int length); // ordered by username
	public List<Score> findScoreRange(int minGames, int start, int length); // ordered by ratio, gamesPlayed >= minGames
}
