package be.technobel.domain.repository.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import be.technobel.domain.entity.Character;
import be.technobel.domain.repository.interfaces.character.CharacterRepositoryLocal;
import be.technobel.domain.repository.jpa.generic.GenericRepositoryJpa;

/**
 * @author jonmeu
 *
 */
/**
 * Session Bean implementation class CharacterRepository
 */
@Stateless(name = "CharacterRepositoryBean")
public class CharacterRepositoryJpa extends GenericRepositoryJpa<Character> implements CharacterRepositoryLocal {

	@Override
	public List<Character> findFor2players() {
		TypedQuery<Character> query = em.createNamedQuery("Character.findFor2players",Character.class);
		return query.getResultList();
		
	}

	@Override
	public List<Character> findFor3players() {
		TypedQuery<Character> query = em.createNamedQuery("Character.findFor3players",Character.class);
		return query.getResultList();
	}

}