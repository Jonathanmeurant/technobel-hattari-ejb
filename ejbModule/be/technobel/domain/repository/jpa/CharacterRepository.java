package be.technobel.domain.repository.jpa;

import be.technobel.domain.entity.Character;
import be.technobel.domain.repository.interfaces.character.CharacterRepositoryLocal;
import be.technobel.domain.repository.jpa.generic.GenericRepositoryJpa;

import javax.ejb.Stateless;

/**
 * @author jonmeu
 *
 */
/**
 * Session Bean implementation class CharacterRepository
 */
@Stateless(name = "CharacterRepositoryBean")
public class CharacterRepository extends GenericRepositoryJpa<Character> implements CharacterRepositoryLocal {

    /**
     * Default constructor. 
     */
    public CharacterRepository() {
        // TODO Auto-generated constructor stub
    }

}
