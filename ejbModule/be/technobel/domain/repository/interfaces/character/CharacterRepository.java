package be.technobel.domain.repository.interfaces.character;

import java.util.List;

import be.technobel.domain.entity.Character;
import be.technobel.domain.repository.interfaces.GenericRepository;

/**
 * @author jonmeu
 *
 */

public interface CharacterRepository extends GenericRepository<Character> {

	
	public List<Character> findFor2players();
	public List<Character> findFor3players();
}
